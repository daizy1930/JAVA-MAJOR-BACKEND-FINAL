package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repositiories.UserRepo;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepo ur;
	
	@Override
	public long getUserCount() {
		return ur.count();
	}

}
