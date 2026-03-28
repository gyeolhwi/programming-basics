package com.sutdy.SpringSecurity.repository;

import com.sutdy.SpringSecurity.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
                                                    // User,KeyType
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}