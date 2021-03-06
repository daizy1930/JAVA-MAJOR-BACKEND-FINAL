package com.example.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpSession;

import com.example.entity.Comment;
import com.example.entity.Course;
import com.example.entity.EnrolledCourses;
import com.example.entity.Feedback;
import com.example.entity.Profile;
import com.example.entity.User;
import com.example.entity.Video;

public interface UserService {
	public Comment addComment(int userID,int courseID,String msg);
	public boolean deleteComment(int commentid);
	public Comment updateComment(int userid, int courseid, int commentid, String comment_msg);
	public List<Comment> fetchComment(int id);
	boolean isCourseCompleted(int cid, int uid);
	public Feedback addFeedback(int uid, int cid,String feedback,int rating);
	public boolean deleteFeedback(int feedbackid);
	public Feedback updateFeedback(int userid, int courseid, int feedbackid, String feedback_msg);
	public List<Feedback> fetchFeedbacks(int id);
	public List<Course> fetchcompletedCourses(int userId);
	public List<Course> AllCourse();
	public List<Course> setAvgRating(List<Course> courses);
	public Optional<Course> getCourseById(int courseid);
	Optional<Course> setAvgRating(Optional<Course> c);
	public int feedbackcount(int courseid);
	public int commentcount(int courseid);
	public List<Video> getVideos(int courseId);
	public boolean like(int i, int cid);
	public boolean unlike(int likeid, int cid);
	public boolean isliked(int cid,int uid);
	public boolean Enroll(int cid, int uid);
	public boolean isenrolled(int cid, int uid);
	List<Course> getEnrolledCourse(int uid);
	List<Video> getEnrolledCourseVideo(int uid, int cid);
	boolean nextVideo(int cid, int uid, int vid);
	boolean completeVideo(int cid, int uid, int vid);
	boolean generateCompeletionCerti(int uid, int cid);
	int regotp(int userid, HttpSession session) throws AddressException, MessagingException;
	boolean clearfalied(int uid);
	boolean isLocked(String username);
	String createUser(User user);
	boolean isActivated(int uid);
	int incrementfailed(String username);
	boolean lockAccount(int uid);
	boolean unlocakAccount(int uid);
	boolean verifyOtp(String username,boolean status);
	public int forgototp(String email) throws AddressException, MessagingException;
	public void changepassword(String password, String email);
	public void sendcert(String email,int userid,int courseid) throws AddressException, MessagingException, IOException;
	public Profile createProfile(int userid, Profile profile);
	public boolean isProfileCreated(int uid);
	public Profile getProfileDetails(int userid);
	public boolean checkUsername(String username);
	public boolean checkEmail(String email);
	public boolean deleteUser(int id);
	public List<Course> findCourseByCat(int catId);
	
}