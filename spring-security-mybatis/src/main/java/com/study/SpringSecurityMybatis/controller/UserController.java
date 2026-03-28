package com.study.SpringSecurityMybatis.controller;

import com.study.SpringSecurityMybatis.dto.request.ReqProfileImgDto;
import com.study.SpringSecurityMybatis.security.principal.PrincipalUser;
import com.study.SpringSecurityMybatis.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/me")
    public ResponseEntity<?> getUserMe() {
        PrincipalUser principalUser =
                (PrincipalUser) SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getPrincipal();

        return ResponseEntity.ok().body(userService.getUserInfo(principalUser.getId()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.getUserInfo(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.deleteUser(id));
    }

    @PatchMapping("/img")
    public ResponseEntity<?> updateProfileImg(@RequestBody ReqProfileImgDto dto) {
        return ResponseEntity.ok().body(userService.updateProfileImg(dto));
    }
}
