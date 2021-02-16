package com.ernesto.springsecuritywithjwt;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import com.ernesto.springsecuritywithjwt.model.User;
import com.ernesto.springsecuritywithjwt.repository.UserRespository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringSecurityWithJwtApplication {

	@Autowired
	private UserRespository userRepository;

	@PostConstruct
	public void initUsers() {
		List<User> users = Stream.of(
			new User(101, "ernesto", "password", "ernesto@teste.com"),
			new User(102, "rubens", "pwd1", "rubens@teste.com"),
			new User(103, "lopes", "pwd2", "lopes@teste.com"),
			new User(104, "batista", "pwd3", "batista@teste.com")
		).collect(Collectors.toList());
		userRepository.saveAll(users);
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityWithJwtApplication.class, args);
	}

}
