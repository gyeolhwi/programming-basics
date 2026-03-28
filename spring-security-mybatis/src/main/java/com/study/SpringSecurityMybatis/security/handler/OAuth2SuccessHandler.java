package com.study.SpringSecurityMybatis.security.handler;

import com.study.SpringSecurityMybatis.entity.User;
import com.study.SpringSecurityMybatis.repository.UserMapper;
import com.study.SpringSecurityMybatis.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Component
public class OAuth2SuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JwtProvider jwtProvider;

    // 필터 없는 것으로 오버라이드 해주기
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        DefaultOAuth2User defaultOAuth2User = (DefaultOAuth2User) authentication.getPrincipal();
        Map<String, Object> attributes = defaultOAuth2User.getAttributes();
        System.out.println("9012348012840912384092138490829431234");
        System.out.println(attributes.get("id"));
        System.out.println(attributes);

        String oAuth2Name = attributes.get("id").toString();
        String provider = attributes.get("provider").toString();

        User user = userMapper.findUserByOAuth2Name(authentication.getName());
        if (user == null) {
            response.sendRedirect("http://localhost:3000/user/join/oauth2?oAuth2Name=" + oAuth2Name + "&provider=" + provider);
            return;
        }
//        super.onAuthenticationSuccess(request, response, authentication);
        String accessToken = jwtProvider.generateAccessToken(user);
        response.sendRedirect("http://localhost:3000/user/login/oauth2?accessToken=" + accessToken);
    }

/*
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {
        System.out.println(authentication.getName());
        super.onAuthenticationSuccess(request, response, chain, authentication);
    }

 */

}
