package com.java.sms.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.java.service.CourseService;
import com.java.service.TeacherService;
import com.java.sms.entity.Course;
import com.java.sms.entity.Teacher;

@Controller
public class TeacherController {
	private TeacherService teacherService;
	private CourseService courseService;

	public TeacherController(TeacherService teacherService, CourseService courseService) {
		super();
		this.teacherService = teacherService;
		this.courseService = courseService;
	}
	

	
	@GetMapping("/teachers")
	public String listTeachers(Model model) {
		model.addAttribute("teachers", teacherService.getAllTeachers());
		return "teachers";
	}
	
	@GetMapping("/teachers/new")
	public String createTeacherForm(Model model) {
		
		// create teacher object to hold teacher form data
		Teacher teacher = new Teacher();
		List<Course> course = courseService.getAllCourse();
		model.addAttribute("course", course);
		model.addAttribute("teacher", teacher);
		return "create_teacher";
		
	}
	
	@PostMapping("/teachers")
	public String saveTeacher(@ModelAttribute("teacher") Teacher teacher) {
		teacherService.saveTeacher(teacher);
		return "redirect:/teachers";
	}
	
	@GetMapping("/teachers/edit/{id}")
	public String editTeacherForm(@PathVariable Long id, Model model) {
		model.addAttribute("teacher", teacherService.getTeacherById(id));
		List<Course> course = courseService.getAllCourse();
		model.addAttribute("course", course);
		return "edit_teacher";
	}

	@PostMapping("/teachers/{id}")
	public String updateTeacher(@PathVariable Long id,
			@ModelAttribute("teacher") Teacher teacher) {
		
		// get teacher from database by id
		Teacher existingTeacher = teacherService.getTeacherById(id);
		existingTeacher.setId(id);
		existingTeacher.setFirstName(teacher.getFirstName());
		existingTeacher.setLastName(teacher.getLastName());
		existingTeacher.setEmail(teacher.getEmail());
		existingTeacher.setCourse(teacher.getCourse());
		
		// save updated teacher object
		teacherService.updateTeacher(existingTeacher);
		return "redirect:/teachers";		
	}
	
	// handler method to handle delete teacher request
	
	@GetMapping("/teachers/{id}")
	public String deleteTeacher(@PathVariable Long id) {
		teacherService.deleteTeacherById(id);
		return "redirect:/teachers";
	}
	
}
