package com.example.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Certificate {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int certiId;
	private String certiPath;
	
	@ManyToOne(targetEntity = Course.class, fetch = FetchType.LAZY)
	@JoinColumn(name="courseId", referencedColumnName = "courseId")
	private Course course;
	
	
	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	@JoinColumn(name="userId", referencedColumnName = "userId")
	private User user;


	public Certificate(String certiPath, Course course, User user) {
		super();
		this.certiPath = certiPath;
		this.course = course;
		this.user = user;
	}


	public Certificate() {
		super();
	}


	public int getCertiId() {
		return certiId;
	}


	public void setCertiId(int certiId) {
		this.certiId = certiId;
	}


	public String getCertiPath() {
		return certiPath;
	}


	public void setCertiPath(String certiPath) {
		this.certiPath = certiPath;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


}