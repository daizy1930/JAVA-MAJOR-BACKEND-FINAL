package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Comment{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int commentId;
	private String comment;
	
	
//	@ManyToOne
//	@JoinColumns({@JoinColumn(name="courseId", referencedColumnName = "courseId"),@JoinColumn(name="userId", referencedColumnName = "userId")})
//	private Course course;
//	private User user;
	
	@ManyToOne(targetEntity = Course.class ,fetch = FetchType.LAZY)
	@JoinColumn(name="courseId")
	private Course course;
	
	@ManyToOne( targetEntity = User.class,fetch = FetchType.LAZY)
	@JoinColumn(name="userId")
	private User user;
	
	
	
	
//	
//	public int getTempid() {
//		return tempid;
//	}
//
//	public void setTempid(int tempid) {
//		this.tempid = tempid;
//	}


	public Comment() {
		super();
	}

	

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


	public Comment(String comment) {
		super();
		this.comment = comment;
	}


	@JsonIgnore
	@JsonProperty(value = "course")
	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}

	//@JsonIgnore
	//@JsonProperty(value = "user")
	public String getUser() {
		return user.getUsername();
	}


	
	public void setUser(User user) {
		this.user = user;
	}


	public Comment(int commentId, Course course, User user) {
		super();
		this.commentId = commentId;
		this.course = course;
		this.user = user;
	}
	


	public Comment(int commentId, String comment) {
		super();
		this.commentId = commentId;
		this.comment = comment;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + commentId;
		result = prime * result + ((course == null) ? 0 : course.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (commentId != other.commentId)
			return false;
		if (course == null) {
			if (other.course != null)
				return false;
		} else if (!course.equals(other.course))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	
	
	
}