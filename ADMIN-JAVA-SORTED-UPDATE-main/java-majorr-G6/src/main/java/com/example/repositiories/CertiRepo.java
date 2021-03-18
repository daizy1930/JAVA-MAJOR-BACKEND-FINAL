package com.example.repositiories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Certificate;
import com.example.entity.Course;
import com.example.entity.User;

public interface CertiRepo extends JpaRepository<Certificate, Integer>{
	
	public Certificate findByUserAndCourse(User u,Course c);
}
