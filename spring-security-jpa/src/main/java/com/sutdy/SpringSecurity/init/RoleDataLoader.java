package com.sutdy.SpringSecurity.init;

import com.sutdy.SpringSecurity.domain.entity.Role;
import com.sutdy.SpringSecurity.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RoleDataLoader implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception { // 배열 문법
        // role 테이블에 ROLE_USER라는 이름이 없다면 TRUE
        if (roleRepository.findByName("ROLE_USER").isEmpty()) {
            roleRepository.save(Role.builder().name("ROLE_USER").build());
        }
        if (roleRepository.findByName("ROLE_MANAGER").isEmpty()) {
            roleRepository.save(Role.builder().name("ROLE_MANAGER").build());
        }
        if (roleRepository.findByName("ROLE_ADMIN").isEmpty()) {
            roleRepository.save(Role.builder().name("ROLE_ADMIN").build());
        }
    }
}
