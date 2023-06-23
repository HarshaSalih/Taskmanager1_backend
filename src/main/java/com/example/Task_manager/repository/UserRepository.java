package com.example.Task_manager.repository;

import com.example.Task_manager.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Integer> {
    Users findByEmail(String email);
}
