package com.ernesto.springsecuritywithjwt.repository;

import com.ernesto.springsecuritywithjwt.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends JpaRepository<User, Integer>{
   User findByUserName(String username);
}
