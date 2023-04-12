package com.java.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.java.sms.entity.Teacher;



@Service
public interface TeacherService {
List<Teacher> getAllTeachers();
	
	Teacher saveTeacher(Teacher teacher);
	
	Teacher getTeacherById(Long id);
	
	Teacher updateTeacher(Teacher teacher);
	
	void deleteTeacherById(Long id);
}
