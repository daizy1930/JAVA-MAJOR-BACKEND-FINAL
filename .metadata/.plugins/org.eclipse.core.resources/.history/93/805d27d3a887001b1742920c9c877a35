package com.example.repositiories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Category;
import com.example.entity.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

	public Course findByCourseName(String name);
}
