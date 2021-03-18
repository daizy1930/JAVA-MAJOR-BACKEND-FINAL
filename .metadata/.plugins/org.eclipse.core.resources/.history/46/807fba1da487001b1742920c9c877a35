package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.UserService;


@RestController
@CrossOrigin
public class UserController {
	@Autowired
	UserService usi;
	
	
	//show all users
	@GetMapping("/user/total")
	public long totalUsers() {
		return usi.getUserCount();
	}
	
}
