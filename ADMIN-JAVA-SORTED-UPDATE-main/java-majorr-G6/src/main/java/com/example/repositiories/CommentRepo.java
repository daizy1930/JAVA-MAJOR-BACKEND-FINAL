  
package com.example.repositiories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.entity.Comment;
import com.example.entity.Course;
import com.example.entity.User;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
	public boolean deleteByUserAndCourse(User u,Course c);
	public List<Comment> findAllByCourse(Course c);
	
	@Query(value = "SELECT cm.comment_id,cm.comment,u.username,cm.course_id,cm.user_id FROM user u,comment cm where u.user_id=cm.user_id and cm.course_id=?1", nativeQuery = true)
	public List<Comment> fetchComment(int id);
}