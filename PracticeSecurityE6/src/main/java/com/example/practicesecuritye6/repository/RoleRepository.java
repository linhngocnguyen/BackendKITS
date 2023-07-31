package com.example.practicesecuritye6.repository;

import com.example.practicesecuritye6.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
