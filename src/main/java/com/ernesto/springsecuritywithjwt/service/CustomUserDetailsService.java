package com.ernesto.springsecuritywithjwt.service;

import java.util.ArrayList;

import com.ernesto.springsecuritywithjwt.model.User;
import com.ernesto.springsecuritywithjwt.repository.UserRespository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

   @Autowired
   private UserRespository repository;

   @Override
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user = repository.findByUserName(username);
      return new org.springframework.security.core.userdetails
            .User(user.getUserName(), user.getPassword(), new ArrayList<>());
   }
   
}
