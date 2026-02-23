package com.example.architecture.repository;

import com.example.architecture.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(int id);
}
