package com.codePro.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codePro.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	
}
