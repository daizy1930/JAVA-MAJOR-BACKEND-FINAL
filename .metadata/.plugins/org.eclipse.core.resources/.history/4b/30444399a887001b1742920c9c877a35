package com.example.repositiories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Course;
import com.example.entity.EnrolledCourses;
import com.example.entity.User;

public interface EnrolledCourseRepo extends JpaRepository<EnrolledCourses, Integer>{
	public EnrolledCourses findByUserAndCourse(User u,Course c);
	
}
