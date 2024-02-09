package com.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.entity.User;
import java.util.List;


public interface UserRepository extends JpaRepository<User, Integer>{

	User  findByUemail(String uemail);
}
