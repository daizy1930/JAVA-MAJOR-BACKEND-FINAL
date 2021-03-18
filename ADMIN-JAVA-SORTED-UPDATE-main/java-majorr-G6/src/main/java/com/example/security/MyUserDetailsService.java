package com.example.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.repositiories.UserRepo;

import java.util.*;

@Service(value = "userService")
public class MyUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepo ur;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = ur.findByUsername(username);
		if(user == null){
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
	}

	private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
//		user.getRole().forEach(role -> {
//            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
//		});
        authorities.add(new SimpleGrantedAuthority( user.getRole()));
		return authorities;
	}   
}