package com.librarysystem.demo.repository;

import com.librarysystem.demo.model.User;



import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    
    
}
