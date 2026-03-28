package com.sutdy.SpringSecurity.service;


import com.sutdy.SpringSecurity.aspect.annotaion.TimeAop;
import com.sutdy.SpringSecurity.domain.entity.Role;
import com.sutdy.SpringSecurity.domain.entity.User;
import com.sutdy.SpringSecurity.dto.request.ReqSignupDto;
import com.sutdy.SpringSecurity.repository.RoleRepository;
import com.sutdy.SpringSecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class SignupService {

    private final UserRepository repository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @TimeAop
    @Transactional(rollbackFor = Exception.class)
    public User signup(ReqSignupDto dto) {
        User user = dto.toEntity(passwordEncoder);
        Role role = roleRepository.findByName("ROLE_USER").orElseGet(
                () -> roleRepository.save(Role.builder().name("ROLE_USER").build())
        );
        user = repository.save(user); // 해당데이터를 가지고옴
        user.setRoles(Set.of(role));

        /*
        UserRole userRole = UserRole.builder()
                .user(user)
                .role(role)
                .build();

        userRole = userRoleRepository.save(userRole);
         */

//        repository.findByUsername(dto.getUsername());
        return user;
    }

    public boolean isDuplicateUsername(String username) {
        return repository.findByUsername(username).isPresent(); // null 체크 isPresent
    }
}
