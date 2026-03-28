package com.study.SpringSecurityMybatis.repository;

import com.study.SpringSecurityMybatis.entity.OAuth2User;
import com.study.SpringSecurityMybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OAuth2UserMapper {
    //    User findUserByOAuth2Name(String oAuth2Name);
    int save(OAuth2User oAuth2User);
}
