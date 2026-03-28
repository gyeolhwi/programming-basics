package com.study.SpringSecurityMybatis.service;

import com.study.SpringSecurityMybatis.dto.request.ReqOAuth2SignupDto;
import com.study.SpringSecurityMybatis.entity.Role;
import com.study.SpringSecurityMybatis.entity.User;
import com.study.SpringSecurityMybatis.entity.UserRoles;
import com.study.SpringSecurityMybatis.repository.OAuth2UserMapper;
import com.study.SpringSecurityMybatis.repository.RoleMapper;
import com.study.SpringSecurityMybatis.repository.UserMapper;
import com.study.SpringSecurityMybatis.repository.UserRolesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class OAuth2Service implements OAuth2UserService {

    private final OAuth2UserMapper oAuth2UserMapper;
    private final UserMapper userMapper;
    private final RoleMapper roleMapper;
    private final UserRolesMapper userRolesMapper;
    private final DefaultOAuth2UserService defaultOAuth2UserService;
    private final BCryptPasswordEncoder passwordEncoder;


    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        // 생성
//        OAuth2UserService<OAuth2UserRequest,OAuth2User> service = new DefaultOAuth2UserService();
        // 구글 로그인 창에서 스프링 부트 서버로 요청날림 -> userInfoEndpoin(securityConfig) 동작 -> 유저 정보를 서비스에 전달(userRequest가 받음, Dto처럼)

        // userRequest에 에러가 있으면 예외처리해주고 정상적인 동작을하면 attributes 확인, access토큰 꺼내서 요청날림 -> yml에서 지정한 scope를 key로 우리가 필요한 userInfo가지고옴
        // attributeName = id, sub, 네이버 response
        OAuth2User oAuth2User = defaultOAuth2UserService.loadUser(userRequest);
        Map<String, Object> attributes = oAuth2User.getAttributes();

        // 공간 만들어주기 {provider,id}
        Map<String, Object> oAuth2Attributes = new HashMap<>();

        oAuth2Attributes.put("provider", userRequest.getClientRegistration().getClientName());

        switch (userRequest.getClientRegistration().getClientName()) {
            case "Google":
                oAuth2Attributes.put("id", attributes.get("sub").toString());
                break;
            case "Naver":
                // 네이버의 경우 한번 더 꺼내줘야함 Object이기 때문에 다운캐스팅
                attributes = (Map<String, Object>) attributes.get("response");
                oAuth2Attributes.put("id", attributes.get("id").toString());
                break;
            case "Kakao":
                oAuth2Attributes.put("id", attributes.get("id").toString());
                break;
        }

        System.out.println("클라이언트");
        System.out.println(userRequest.getClientRegistration());
        System.out.println("어트리뷰트");
        System.out.println(oAuth2User.getAttributes()); // 에서 response라는 것만 꺼내면 네이버에서 쓰는 구문
        System.out.println("Authorities");
        System.out.println(oAuth2User.getAuthorities());
        System.out.println("이름");
        System.out.println(oAuth2User.getName());


        // 권한, 속성, usernameAttribute
        return new DefaultOAuth2User(new HashSet<>(), oAuth2Attributes, "id");
    }

    public void merge(com.study.SpringSecurityMybatis.entity.OAuth2User oAuth2User) {
        oAuth2UserMapper.save(oAuth2User);
    }

    @Transactional(rollbackFor = Exception.class)
    public void signup(ReqOAuth2SignupDto dto) {
        User user = dto.toEntity(passwordEncoder);
        userMapper.save(user);
        Role role = roleMapper.findByName("ROLE_USER");
        if (role == null) {
            role = Role.builder().name("ROLE_USER").build();
            roleMapper.save(role);
        }
        userRolesMapper.save(UserRoles.builder()
                .userId(user.getId())
                .roleId(role.getId())
                .build());

        oAuth2UserMapper.save(com.study.SpringSecurityMybatis.entity.OAuth2User.builder()
                .userId(user.getId())
                .oAuth2Name(dto.getOauth2Name())
                .provider(dto.getProvider())
                .build());
    }
}

/*
        String id = oAuth2User.getName(); // kakao, Google의 경우에는 바로 id값이 들어감
        if (userRequest.getClientRegistration().getClientName().equals("Naver")) {
//            Map<String, Object> attributes = (Map<String, Object>) oAuth2User.getAttribute("response");
            id = (String) attributes.get("id");
        }

 */