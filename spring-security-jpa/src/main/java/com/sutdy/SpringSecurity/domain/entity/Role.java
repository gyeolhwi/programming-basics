package com.sutdy.SpringSecurity.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;        // ROLE_USER, ROLE_ADMIN, ROLE_MANAGER

    /*
        @ManyToMany(mappedBy = "roles") // 다대다관계형성 -> User에 있는 roles찾음
        private Set<User> users;
     */

//    @OneToMany(mappedBy = "role") // ?
//    private Set<UserRole> userRoles = new HashSet<>();
}
