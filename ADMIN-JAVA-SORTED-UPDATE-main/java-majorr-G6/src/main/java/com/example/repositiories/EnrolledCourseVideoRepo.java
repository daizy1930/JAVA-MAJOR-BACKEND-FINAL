package com.example.repositiories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.EnrolledCourseVideo;
import com.example.entity.EnrolledCourses;
import com.example.entity.Video;


@Repository
public interface EnrolledCourseVideoRepo extends JpaRepository<EnrolledCourseVideo, Integer>{
	public List<EnrolledCourseVideo> findAllByEc(EnrolledCourses ec);
}
