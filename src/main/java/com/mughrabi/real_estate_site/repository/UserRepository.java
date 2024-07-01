package com.mughrabi.real_estate_site.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mughrabi.real_estate_site.model.User;


public interface UserRepository extends JpaRepository<User, Integer>{
    
}
