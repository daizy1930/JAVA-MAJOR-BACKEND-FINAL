package com.example.repositiories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.Course;
import com.example.entity.Video;
@Repository
public interface VideoRepository extends JpaRepository<Video, Integer>{

	@Query(value = "SELECT v.video_id,v.video_desc,v.video_name,v.video_path,v.course_id  FROM video v,enrolled_courses ec where v.course_id=ec.course_id and ec.user_id=?1 and v.course_id=?2", nativeQuery = true)
	List<Video> getVideo(int uid,int cid);

	List<Video> findAllByCourse(Course course);

}
