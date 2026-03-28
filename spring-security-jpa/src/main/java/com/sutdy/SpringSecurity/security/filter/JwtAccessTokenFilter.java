package com.sutdy.SpringSecurity.security.filter;

import com.sutdy.SpringSecurity.domain.entity.User;
import com.sutdy.SpringSecurity.repository.UserRepository;
import com.sutdy.SpringSecurity.security.jwt.JwtProvider;
import com.sutdy.SpringSecurity.security.principal.PrincipalUser;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Optional;

@Component
public class JwtAccessTokenFilter extends GenericFilter {
    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String bearerAccessToken = request.getHeader("Authorization"); // header에 있는 key값을 가지고온다

        // 공급자에서 받는 토큰 값이 있는지 확인
        if (bearerAccessToken != null) {
            String accesssToken = jwtProvider.removeBearer(bearerAccessToken); // 문자열 삭제해주고 토큰값만 담기
            Claims claims = null;

            try {
                claims = jwtProvider.parseToken(accesssToken); // 클래임이라는 키밸류 공간에 jwt토큰 변환해서 가지고옴 그러고 토큰 던져준다 메소드실행되면 페이로드값 가지고옴
            } catch (Exception e) {
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }


            Long userId = ((Integer) claims.get("userId")).longValue(); // 위에 claims 작업 진행 후 이안에서 userId 담음
            Optional<User> optionalUser = userRepository.findById(userId); // db에 userId 있는지 확인

            if (optionalUser.isEmpty()) { // userId가 없으면 filter
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }

            PrincipalUser principalUser = optionalUser.get().toPrincipalUser(); // 이제 유저정보를 담을준비 한다?
            Authentication authentication = new UsernamePasswordAuthenticationToken(principalUser, principalUser.getPassword(), principalUser.getAuthorities()); // 해당변수안에 유저정보와 권한을 짜집기해서 줌

            // ⭐⭐⭐ 시큐리티홀더안에 Authentication안에 인증된 사용자여야지만 doFilter에서 넘어감 어디로 넘어가? config에서 해놓은 상황대로
            SecurityContextHolder.getContext().setAuthentication(authentication); // 준다. 객체가 없으면 인증이 안 되어있는거임 ->

            System.out.println("예외 발생하지 않았음");
        }

        System.out.println(bearerAccessToken);
        filterChain.doFilter(servletRequest, servletResponse);
    }

}
