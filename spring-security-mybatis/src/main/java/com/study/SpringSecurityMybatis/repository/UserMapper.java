package com.study.SpringSecurityMybatis.repository;

import com.study.SpringSecurityMybatis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User findById(Long id);
    User findByUsername(String username);
    int save(User user);
    int deleteById(Long id);
    // 해당키값 명확하게 하기위해 명시
    int modifyImgById(@Param("id") Long id, @Param("img") String img);

    User findUserByOAuth2Name(String oAuth2Name);
}
