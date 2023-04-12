package com.java.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java.sms.entity.Course;


@Service
public interface CourseService {
	List<Course> getAllCourse();
	
	Course saveCourse(Course course);
	
	Course getCourseById(Long id);
	
	Course updateCourse(Course course);
	
	void deleteCourseById(Long id);

}
