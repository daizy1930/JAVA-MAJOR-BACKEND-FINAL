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
public class EnrolledCourseVideo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ecvId;
	private int timeSeen;
	private boolean completed;
	
	
	@ManyToOne(targetEntity = EnrolledCourses.class, fetch = FetchType.LAZY)
	@JoinColumn(name="ecourseId", referencedColumnName = "ecourseId")
	private EnrolledCourses ec;
	
	@ManyToOne(targetEntity = Video.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="videoId", referencedColumnName = "videoId")
	private Video video;

	public EnrolledCourseVideo() {
		super();
	}

	public EnrolledCourseVideo(int timeSeen, boolean completed, Video video, EnrolledCourses ec) {
		super();
		this.timeSeen = timeSeen;
		this.completed = completed;
		this.video = video;
		this.ec = ec;
	}

	public int getEcvId() {
		return ecvId;
	}

	public void setEcvId(int ecvId) {
		this.ecvId = ecvId;
	}

	public int getTimeSeen() {
		return timeSeen;
	}

	public void setTimeSeen(int timeSeen) {
		this.timeSeen = timeSeen;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public EnrolledCourses getEc() {
		return ec;
	}

	public void setEc(EnrolledCourses ec) {
		this.ec = ec;
	}

	public int getVideo() {
		return video.getVideoId();
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	
	
	
	
}