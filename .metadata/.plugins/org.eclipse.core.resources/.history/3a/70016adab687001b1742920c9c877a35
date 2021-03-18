package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.repositiories.CategoryRepository;
import com.example.repositiories.CourseRepository;
import com.example.repositiories.UserRepo;
import com.example.repositiories.VideoRepository;
import com.example.entity.Category;
import com.example.entity.Course;
import com.example.entity.User;
import com.example.entity.Video;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	CategoryRepository cat;
	@Autowired
	CourseRepository cou;
	@Autowired
	VideoRepository vr;

	@Autowired
	UserRepo ur;

	@Override
	public List<Category> getAllCategory() {
		return cat.findAll();
	}

	@Override
	public Optional<Category> getCategoryById(int id) {
		return cat.findById(id);
	}

	@Override
	public boolean addCategory(Category c) {
		return cat.save(c) != null;
	}

	@Override
	public void deleteCategory(int id) {
		cat.deleteById(id);

	}

	@Override
	public boolean updateCategory(Category c, Optional<Category> ctest, int id) {
		List<Course> cotest = ctest.get().getCourses();
		c.setCourses(cotest);
		return cat.save(c) != null;
	}

	@Override
	public List<Course> getAllCourse() {
		return cou.findAll();
	}

	@Override
	public Optional<Course> getCourseById(int id) {
		return cou.findById(id);
	}

	@Override
	public boolean addCourse(Course c, int id) {
		Optional<Category> cate = cat.findById(id);
		List<Course> courses = cate.get().getCourses();
		courses.add(c);
		cate.get().setCourses(courses);
		cat.save(cate.get());
		return true;
	}

	@Override
	public void deleteCourse(int i) {
		cou.deleteById(i);

	}

	@Override
	public boolean updateCourse(Course c, Optional<Course> ctest) {
		List<Video> video = ctest.get().getVideo();
		String cat_name = ctest.get().getCategory();
		Category category = cat.findByCategoryName(cat_name);
		c.setCategory(category);
		c.setVideo(video);
		return cou.save(c) != null;
	}

	@Override
	public boolean addVideo(Video v, int id) {
		Optional<Course> co = cou.findById(id);
		List<Video> videos = co.get().getVideo();
		videos.add(v);
		co.get().setVideo(videos);
		cou.save(co.get());
		return true;
	}

	@Override
	public List<Video> getAllVideo() {
		return vr.findAll();
	}

	@Override
	public Optional<Video> getVideoById(int id) {
		return vr.findById(id);
	}

	@Override
	public boolean updateVideo(Video v, int id) {
		Optional<Video> video = vr.findById(v.getVideoId());
		Course course = cou.findByCourseName(video.get().getCourse());
		v.setCourse(course);
		vr.save(v);
		return true;
	}

	@Override
	public void deleteVideo(int i) {
		vr.deleteById(i);

	}

	@Override
	public long getCategoryCount() {
		return cat.count();
	}

	@Override
	public long getCourseCount() {
		return cou.count();
	}

	@Override
	public long getVideoCount() {
		return cou.count();
	}

	@Override
	public boolean lockAccount(int uid) {
		Optional<User> user = ur.findById(uid);
		user.get().setLocked(true);
		ur.save(user.get());
		return true;
	}

	@Override
	public boolean unlocakAccount(int uid) {
		Optional<User> user = ur.findById(uid);
		user.get().setLocked(false);
		ur.save(user.get());
		return true;
	}

	@Override
	public List<User> getLockedAccount() {
		return ur.getLockedUsers();
	}

	@Override
	public List<User> getAllUser() {
		return ur.findAll();
	}

}
