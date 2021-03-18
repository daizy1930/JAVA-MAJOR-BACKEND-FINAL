package com.example.repositiories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	@Query(value = "SELECT * FROM user where locked=true", nativeQuery = true)
	List<User> getLockedUsers();
	
	
	@Query("select u.username from User u where u.username = ?1") 
	public String findByUserrname(String username);
	
//	@Query("select u.email from User u where u.email = ?1") 
//	public String findByEmail(String email);
	
	@Query("select u.password from User u where u.password = ?1") 
	public String findByPassword(String password);
	
	@Query("select u from User u where u.userId = ?1")
	public Optional<User> findUserDetails(int id);
	
	@Query("select u.password from User u where u.userId =:id")
	public String findPassword(@Param("id") int id);
	
	@Query("select u.username from User u where u.username =?1")
	public String checkUserName(String username);
	
	public User findByUsername(String name);
	
	public User findByEmail(String email);


	@Query("select u.email from User u where u.email =?1")
	public String checkEmail(String email);
	
}