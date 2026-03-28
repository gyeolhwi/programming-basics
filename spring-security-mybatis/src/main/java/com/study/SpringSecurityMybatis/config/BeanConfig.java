package com.study.SpringSecurityMybatis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;

@Configuration
public class BeanConfig {
    
    
    @Bean
    // SecurityConfig 에서 OAuth2Service 연결될 때  DefaultOAuth2UserService 등록되어있어야하기에 따로 빼둠
    public DefaultOAuth2UserService defaultOAuth2UserService() {
        return new DefaultOAuth2UserService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}