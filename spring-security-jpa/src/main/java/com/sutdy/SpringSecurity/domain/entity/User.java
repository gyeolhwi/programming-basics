package com.sutdy.SpringSecurity.domain.entity;

import com.sutdy.SpringSecurity.security.principal.PrincipalUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Entity // table로 만들어주는 애 jpa
@Data
@Builder
public class User {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment설정
    private Long id;

    @Column(unique = true, nullable = false) // not null
    private String username;

    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private String name;

    // fetch : 엔티티를 조인했을 때 연관된 데이터를 언제 가져올지 결정(EAGER - 당장, LAZY - 나중에 사용할 때)

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"), // jpa문법상 Long id -> user_id와 같은거임
            inverseJoinColumns = @JoinColumn(name = "role_id") // 외래키
    )
    private Set<Role> roles;

    public PrincipalUser toPrincipalUser() {
        return PrincipalUser.builder()
                .userId(id)
                .username(username)
                .password(password)
                .roles(roles)
                .build();
    }

//    @OneToMany(mappedBy = "user") // 사용될곳 매칭
//    private Set<UserRole> userRoles = new HashSet<>();


}
