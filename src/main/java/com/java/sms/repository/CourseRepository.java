package com.java.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.sms.entity.Course;


public interface CourseRepository extends JpaRepository<Course, Long> {
	
}
