package com.example.repositiories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.example.entity.Course;
import com.example.entity.Like;
import com.example.entity.User;

public interface LikeRepo extends JpaRepository<Like, Integer>{
	public Like findByCourseAndUser(Course c,User u);
//	@Query("insert into like(user_id values(")
//	public List<Player> fBName(String name);
}
