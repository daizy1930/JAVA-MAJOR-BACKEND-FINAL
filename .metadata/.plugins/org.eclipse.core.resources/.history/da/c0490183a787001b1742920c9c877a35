package com.example.entity;

import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	private String username;
	private String email;
	private String password;
	private boolean locked;
	private boolean activated;
	private String role;
//	@OneToOne(fetch = FetchType.LAZY ,
//	    	
//	    		cascade = CascadeType.ALL,
//	    		mappedBy = "user"
//	    		)
//	private Profile profile;
	
	
	
	@OneToMany(targetEntity = Certificate.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="userId", referencedColumnName = "userId")
    List<Certificate> certies;
	
	@OneToMany(targetEntity = Like.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="userId", referencedColumnName = "userId")
    List<Like> likes;
		
//	
//	 @OneToOne(fetch = FetchType.LAZY,
//	    		optional = false)
//	 @JoinColumn(name="resultID",nullable = false,referencedColumnName = "resultID")
//	 private Result result;
//	
	@OneToMany(targetEntity = Feedback.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="userId", referencedColumnName = "userId")
	List<Feedback> feedbacks;
	
	@OneToMany(targetEntity = EnrolledCourses.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="userId", referencedColumnName = "userId")
	List<EnrolledCourses> ecourse;


	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isLocked() {
		return locked;
	}
	public void setLocked(boolean locked) {
		this.locked = locked;
	}
	public boolean isActivated() {
		return activated;
	}
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public User() {
		super();
	}
	public User(String username, String email, String password) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
	}
	public User(String username, String email, String password, boolean locked, boolean activated,String role) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.locked = false;
		this.activated = false;
		this.role="user";
	}
	
	
//	public String getProfile() {
//		return profile.getFullName();
//	}
//	public void setProfile(Profile profile) {
//		this.profile = profile;
//	}
}
