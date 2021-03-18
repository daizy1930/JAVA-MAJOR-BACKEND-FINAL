package com.example.entity;

import java.sql.Date;
import java.util.List;

 

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

 

@Entity
public class EnrolledCourses {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ecourseId;
	private Date startDate;
	private Date endDate;
	
	

	

	
	@ManyToOne(targetEntity = User.class, fetch = FetchType.LAZY)
	@JoinColumn(name="userId", referencedColumnName = "userId")
	private User user;
	
	@ManyToOne(targetEntity = Course.class, fetch = FetchType.LAZY)
	@JoinColumn(name="courseId", referencedColumnName = "courseId")
	private Course course;
	
//	@ManyToOne(targetEntity = Video.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinColumn(name="videoId", referencedColumnName = "videoId")
//	private Video video;
	
	@OneToMany(targetEntity = EnrolledCourseVideo.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="ecourseId", referencedColumnName = "ecourseId")
	List<EnrolledCourseVideo> ecvideo;

	public int getEcourseId() {
		return ecourseId;
	}

	public void setEcourseId(int ecourseId) {
		this.ecourseId = ecourseId;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}



	public List<EnrolledCourseVideo> getEcvideo() {
		return ecvideo;
	}

	public void setEcvideo(List<EnrolledCourseVideo> ecvideo) {
		this.ecvideo = ecvideo;
	}
	
    
}
 
