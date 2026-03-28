package com.sutdy.SpringSecurity.service;

import com.sutdy.SpringSecurity.aspect.annotaion.ParamsAop;
import com.sutdy.SpringSecurity.domain.entity.User;
import com.sutdy.SpringSecurity.dto.request.ReqSigninDto;
import com.sutdy.SpringSecurity.dto.response.RespJwtDto;
import com.sutdy.SpringSecurity.repository.UserRepository;
import com.sutdy.SpringSecurity.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SigninService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private JwtProvider jwtProvider;

    @ParamsAop
    public RespJwtDto signin(ReqSigninDto dto) {
        // username confirm
        User user = userRepository.findByUsername(dto.getUsername()).orElseThrow(
                () -> new UsernameNotFoundException("사용자 정보를 다시 입력하세요.")
        );
        // password confirm
        if (!passwordEncoder.matches(dto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("사용자 정보를 다시 입력하세요.");
        }

        return RespJwtDto.builder().accessToken(jwtProvider.generateUserToken(user)).build();

    }

}
