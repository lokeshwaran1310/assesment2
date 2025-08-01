package com.example.supportjavaspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.supportjavaspring.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
