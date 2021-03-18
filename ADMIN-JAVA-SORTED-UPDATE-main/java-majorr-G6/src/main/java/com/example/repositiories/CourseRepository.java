package com.example.repositiories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Category;
import com.example.entity.Course;
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{

//	find courese by name
	public Course findByCourseName(String name);
	
	@Query(value = "SELECT c.course_id,c.course_desc,c.course_logo,c.course_name,c.course_price,c.likes,c.category_id FROM course c , enrolled_courses ec where c.course_id=ec.course_id and ec.start_date IS NOT NULL and ec.end_date IS NOT NULL and ec.user_id=?1", nativeQuery = true)
	List<Course> getFinsihedCourses(int uid); 
	
	@Query(value = "SELECT c.course_id,c.course_desc,c.course_logo,c.course_name,c.course_price,c.likes,c.category_id FROM course c , enrolled_courses ec where c.course_id=ec.course_id and ec.start_date IS NOT NULL and ec.end_date IS NULL and ec.user_id=?1", nativeQuery = true)
	List<Course> getEnrolledCourses(int uid); 
	
	public List<Course> findAllByCategory(Category c);
}
