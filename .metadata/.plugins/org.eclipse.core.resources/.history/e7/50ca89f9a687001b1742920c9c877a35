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
	
	@ManyToOne(targetEntity = Course.class,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="courseId", referencedColumnName = "courseId")
	private Course course;

}
