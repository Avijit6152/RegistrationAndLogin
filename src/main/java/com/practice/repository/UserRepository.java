package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
