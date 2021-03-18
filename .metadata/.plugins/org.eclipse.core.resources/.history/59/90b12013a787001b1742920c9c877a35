package com.example.entity;

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
}
