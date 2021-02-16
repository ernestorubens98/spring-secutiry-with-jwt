package com.ernesto.springsecuritywithjwt.controller;

import com.ernesto.springsecuritywithjwt.model.dto.AuthRequest;
import com.ernesto.springsecuritywithjwt.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class WelcomeController {

   @Autowired
   private JwtUtil jwtUtil;

   @Autowired
   private AuthenticationManager authenticationManager;

   @GetMapping
   public String welcome() {
      return "Welcome Ernesto!!";
   }

   @PostMapping("/authenticate")
   public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
      try {
         authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
         );
      } catch (Exception ex) {
         throw new Exception("invalid username/password");
      }
      return jwtUtil.generateToken(authRequest.getUserName());
   }
}
