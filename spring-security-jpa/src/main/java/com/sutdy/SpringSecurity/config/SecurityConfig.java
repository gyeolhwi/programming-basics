package com.sutdy.SpringSecurity.config;

import com.sutdy.SpringSecurity.security.filter.JwtAccessTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity // security에서 제공하는 걸 쓰는 게 아니라 우리가 만든 SecurityConfig를 적용시키겠다
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAccessTokenFilter jwtAccessTokenFilter;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // IOC컨테이너에 등록되면서 해당 메소드가 실행되면서 초기셋팅 발생함

        http.formLogin().disable();
        http.httpBasic().disable();
        http.csrf().disable();

        // 스프링 시큐리티가 세션을 생성하지도 않고 기존의 세션을 사용하지도 않겠다.
//        http.sessionManagement().disable();

        // 스프링 시큐리티가 세션을 생성하지 않겠다. 기존의 세션을 완전히 사용하지 않겠다는 뜻은 아님.
        // JWT등의 토큰 인증방식을 사용할 때 설정하는 것.
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.cors(); // 크로스오리진 활성화 (react,tomcat 통신 허용)

        // 인증 관련 세팅
        http.authorizeRequests()
                .antMatchers("/auth/**","/h2-console/**") //해당요청
                .permitAll() // 허용
                .anyRequest()
                .authenticated()
                .and()
                .headers()
                .frameOptions()
                .disable();

        // 다른요청들은 .authenticated() 발동!
        http.addFilterBefore(jwtAccessTokenFilter, UsernamePasswordAuthenticationFilter.class); // 객체가 없다면  UsernamePasswordAuthenticationFilter -> 403에러 띄워줌(프론트에서 처리)

    }
}
