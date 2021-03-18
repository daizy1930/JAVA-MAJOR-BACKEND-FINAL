package com.example.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;

@Entity
public class Feedback {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int feedbackId;
	private String feedback;
	
	@ManyToOne(targetEntity = Course.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="courseId", referencedColumnName = "courseId")
	private Course course;
	
	@ManyToOne(targetEntity = User.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="userId", referencedColumnName = "userId")
	private User user;

	public Feedback(int feedbackId, String feedback, Course course, User user) {
		super();
		this.feedbackId = feedbackId;
		this.feedback = feedback;
		this.course = course;
		this.user = user;
	}

	public Feedback(String feedback, Course course, User user) {
		super();
		this.feedback = feedback;
		this.course = course;
		this.user = user;
	}

	public Feedback() {
		super();
	}
	
}
