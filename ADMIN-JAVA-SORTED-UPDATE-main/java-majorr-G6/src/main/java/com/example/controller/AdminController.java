package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.service.AdminServiceImpl;

import com.example.entity.Category;
import com.example.entity.Course;
import com.example.entity.User;
import com.example.entity.Video;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminServiceImpl aservice;
	
	//Get course reports
	@GetMapping(path="/coursereports")
	public List<Course> courseReports(){
		return aservice.courseStats();
		
	}
	
	// show all categories
	@GetMapping("/category")
	public ResponseEntity<List<Category>> AllCategory() {
		List<Category> li = aservice.getAllCategory();
		if(li.size()==0) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(li);
		}
		else{
			return ResponseEntity.status(HttpStatus.OK).body(li);
		
		}
	}

	// show category by id
	@GetMapping(value = "/category/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Optional<Category>> CategoryById(@PathVariable int id) {
		
		 Optional<Category> c=aservice.getCategoryById(id);
		 
		 if(c.isEmpty()) {
			 return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(c);
		 }
		 else {
			 return  ResponseEntity.status(HttpStatus.OK).body(c); 
		 }
		 

	}

	// add category
	@PostMapping("/category")
	public  ResponseEntity<Boolean> addCategory(@RequestBody Category c) {
		boolean b= aservice.addCategory(c);
		 if(b==false) {
			 return  ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(b);
		 }
		 else {
			 return  ResponseEntity.status(HttpStatus.OK).body(b); 
		 }
	
	}

	// delete category by id
	@DeleteMapping("/category/{id}")
	public ResponseEntity<Boolean> deleteCategory(@PathVariable int id) {
		
		Optional<Category> c=aservice.getCategoryById(id); 
		 if(c.isEmpty()) {
			 return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
		 }
		 else {
			 aservice.deleteCategory(id);
			 return  ResponseEntity.status(HttpStatus.OK).body(true); 
		 }
		
		
	}

	// update category by id
	@PutMapping("/category/{cat_id}")
	public ResponseEntity<Boolean> updateCategory(@RequestBody Category c, @PathVariable int cat_id) {
		c.setCategoryId(cat_id);
		Optional<Category> ctest=aservice.getCategoryById(cat_id);
		boolean b=aservice.updateCategory(c,ctest,cat_id);
		 if(b==false) {
			 return  ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(b);
		 }
		 else {
			 return  ResponseEntity.status(HttpStatus.OK).body(b); 
		 }

	}
	
	// total categories
	@GetMapping("/category/total")
	public ResponseEntity<Integer> totalCategory() {
		int c;
		c=(int) aservice.getCategoryCount();
		 if(c==0) {
			 return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(c);
		 }
		 else {
			 return  ResponseEntity.status(HttpStatus.OK).body(c); 
		 }
		
		
	}
	
	

	// show all courses
	@GetMapping("/course")
	public ResponseEntity<List<Course>> AllCourse() {
		List<Course> li = aservice.getAllCourse();
		if(li.size()==0) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(li);
			
			}
			else{
				return ResponseEntity.status(HttpStatus.OK).body(li);
			}
		
	}

	// show course by id
	@GetMapping("/course/{id}")
	public ResponseEntity<Optional<Course>> CourseById(@PathVariable int id) {
		
		Optional<Course> c=aservice.getCourseById(id);
		 if(c.isEmpty()) {
			 return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(c);
		 }
		 else {
			 return  ResponseEntity.status(HttpStatus.OK).body(c); 
		 }

	}

	// add course
	@PostMapping("/course/{cat_id}")
	public ResponseEntity<Boolean> addCourse(@RequestBody Course c, @PathVariable int cat_id) {
		boolean b=aservice.addCourse(c, cat_id);
		if(b==false) {
			 return  ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(b);
		 }
		 else {
			 return  ResponseEntity.status(HttpStatus.OK).body(b); 
		 }
	}

	// delete course by id
	@DeleteMapping("/course/{id}")
	public ResponseEntity<Boolean> deleteCourse(@PathVariable int id) {
		Optional<Course> c=aservice.getCourseById(id); 
		if(c.isEmpty()) {
			 return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
		 }
		 else {
			 aservice.deleteCourse(id);
			 return  ResponseEntity.status(HttpStatus.OK).body(true); 
		 }
	}

	// update category by id
	@PutMapping("/course/{co_id}/{cat_id}")
	public ResponseEntity<Boolean> updateCourse(@RequestBody Course c, @PathVariable int co_id,@PathVariable int cat_id) {
		c.setCourseId(co_id);
		Optional<Course> ctest=aservice.getCourseById(co_id);
		boolean b= aservice.updateCourse(c,ctest);
		if(b==false) {
			 return  ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(b);
		 }
		 else {
			 return  ResponseEntity.status(HttpStatus.OK).body(b); 
		 }


	}

	// total courses
		@GetMapping("/course/total")
		public ResponseEntity<Integer> totalCourses() {
			int c;
			c=(int) aservice.getCourseCount();
			 if(c==0) {
				 return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(c);
			 }
			 else {
				 return  ResponseEntity.status(HttpStatus.OK).body(c); 
			 }
			 
		}
	
	
	// show all videos
	@GetMapping("/video")
	public ResponseEntity<List<Video>> AllVideos() {
		List<Video> li2 = aservice.getAllVideo();
		
		if(li2.size()==0) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(li2);
			
			}
			else{
				return ResponseEntity.status(HttpStatus.OK).body(li2);
			}
		
	}

	// show video by id
	@GetMapping("/video/{id}")
	public ResponseEntity<Optional<Video>> VideoById(@PathVariable int id) {
		Optional<Video> v=aservice.getVideoById(id);
		 if(v.isEmpty()) {
			 return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(v);
		 }
		 else {
			 return  ResponseEntity.status(HttpStatus.OK).body(v); 
		 }

	}

	// add video
	@PostMapping("/video/{co_id}")
	public ResponseEntity<Boolean> addVideo(@RequestBody Video c, @PathVariable int co_id) {
		boolean b= aservice.addVideo(c,co_id);
		
		
		if(b==false) {
			 return  ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(b);
		 }
		 else {
			 return  ResponseEntity.status(HttpStatus.OK).body(b); 
		 }
	}

	// delete video
	@DeleteMapping("/video/{id}")
	public ResponseEntity<Boolean> deleteVideo(@PathVariable int id) {
		
		Optional<Video> c=aservice.getVideoById(id); 
		
		if(c.isEmpty()) {
			 return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
		 }
		 else {
			 aservice.deleteVideo(id);
			 return  ResponseEntity.status(HttpStatus.OK).body(true); 
		 }
	}

	// update video by id
	@PutMapping("/video/{v_id}/{co_id}")
	public ResponseEntity<Boolean> updateVideo(@RequestBody Video v, @PathVariable int v_id,@PathVariable int co_id) {
		v.setVideoId(v_id);
		boolean b= aservice.updateVideo(v,co_id);
		
		if(b==false) {
			 return  ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(b);
		 }
		 else {
			 return  ResponseEntity.status(HttpStatus.OK).body(b); 
		 }

		
	}
	
	
	// total courses
	@GetMapping("/video/total")
	public ResponseEntity<Integer> totalVideos() {
		int c;
		c=(int) aservice.getVideoCount();
		 if(c==0) {
			 return  ResponseEntity.status(HttpStatus.NO_CONTENT).body(c);
		 }
		 else {
			 return  ResponseEntity.status(HttpStatus.OK).body(c); 
		 }
	}
	
	
	//show all users
	@GetMapping("/user")
	public ResponseEntity<List<User>> AllUsers() {

		List<User> li = aservice.getAllUser();
		if(li.size()==0) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(li);
			}
			else{
				return ResponseEntity.status(HttpStatus.OK).body(li);
			}
		
	}

	//show locked users
	@GetMapping(path="/lockedusers")
	public ResponseEntity<List<User>> getLocked(){
		
		List<User>userList=aservice.getLockedAccount();
		 
		if(userList.size()==0) {
			return ResponseEntity.status(HttpStatus.OK).body(userList);
		}
		else{
			
			return ResponseEntity.status(HttpStatus.OK).body(userList);
		
		}
	}
	
	//unlock the user
	@PutMapping(path="/unlockuser/{u_id}")
	public ResponseEntity<Boolean> unlock(@PathVariable int u_id){
		boolean b=aservice.unlocakAccount(u_id); 
		 if(b==false) {
			 return  ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(b);
		 }
		 else {
			 return  ResponseEntity.status(HttpStatus.OK).body(b); 
		 }
		 
	}
	
	//lock the user
	@PutMapping(path="/lockuser/{u_id}")
	public ResponseEntity<Boolean> lock(@PathVariable int u_id){
		boolean b= aservice.lockAccount(u_id);
		 if(b==false) {
			 return  ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(b);
		 }
		 else {
			 return  ResponseEntity.status(HttpStatus.OK).body(b); 
		 }
		
		
	}
	@GetMapping("/usercount")
	public long totalUsers() {
		return aservice.getUserCount();
	}

}
