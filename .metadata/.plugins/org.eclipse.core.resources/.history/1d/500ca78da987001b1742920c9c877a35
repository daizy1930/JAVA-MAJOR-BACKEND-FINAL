package com.example.repositiories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	
	@Query(value = "SELECT * FROM user where locked=true", nativeQuery = true)
	List<User> getLockedUsers();
}
