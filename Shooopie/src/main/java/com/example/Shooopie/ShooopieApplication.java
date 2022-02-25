package com.example.Shooopie;

import com.example.Shooopie.Users.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class ShooopieApplication {

	@Autowired
	private UserService userService;

	@PostConstruct
	public void initUser(){
		userService.registerUser("GODA", "1234");
	}


	public static void main(String[] args) {
		SpringApplication.run(ShooopieApplication.class, args);
	}

}
