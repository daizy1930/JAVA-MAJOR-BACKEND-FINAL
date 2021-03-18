package com.example.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.sql.rowset.serial.SerialBlob;


@Entity
public class Profile {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int profileId;
	private String fullName;
	private SerialBlob userImage;
	private Date birthdate;
	private String gender;
//	 @OneToOne(fetch = FetchType.LAZY,
//	    		optional = false)
//	 @JoinColumn(name="userId",nullable = false,referencedColumnName = "userId")
//	 private User user;
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public SerialBlob getUserImage() {
		return userImage;
	}
	public void setUserImage(SerialBlob userImage) {
		this.userImage = userImage;
	}
	public Date getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Profile() {
	
	}
	public Profile(String fullName, SerialBlob userImage, Date birthdate, String gender) {
		super();
		this.fullName = fullName;
		this.userImage = userImage;
		this.birthdate = birthdate;
		this.gender = gender;
	}
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
	
}
