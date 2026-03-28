package com.sutdy.SpringSecurity.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    // 데이터를 가지고 오고자 할 때 주체는 해당클래스다

    /*
    @ManyToMany
    @JoinColumn(name = "user_id") // 경로임
    private User user; // User 맵핑

    @ManyToMany
    @JoinColumn(name ="role_id")
    private Role role;
     */

}
