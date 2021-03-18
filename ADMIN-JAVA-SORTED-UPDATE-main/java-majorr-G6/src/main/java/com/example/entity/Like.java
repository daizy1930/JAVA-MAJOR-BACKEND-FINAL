package com.example.entity;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="Likes")
public class Like {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int likeId;
//	@ManyToOne
//	private Course coures;
//	@ManyToOne
//	private User user;
	
	@ManyToOne(targetEntity = Course.class, fetch = FetchType.EAGER)
	@JoinColumn(name="courseId", referencedColumnName = "courseId")
	private Course course;
	
	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	@JoinColumn(name="userId", referencedColumnName = "userId")
	private User user;

	public int getLikeId() {
		return likeId;
	}

	public void setLikeId(int likeId) {
		this.likeId = likeId;
	}

	protected Course getCourse() {
		return course;
	}

	protected void setCourse(Course course) {
		this.course = course;
	}

	protected User getUser() {
		return user;
	}

	protected void setUser(User user) {
		this.user = user;
	}

	public Like() {
		super();
	}
//
	public Like(Course course, User user) {
		super();
		this.course = course;
		this.user = user;
	}
	
}