package com.example.practicesecuritye6.repository;

import com.example.practicesecuritye6.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
