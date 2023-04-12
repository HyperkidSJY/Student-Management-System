package com.java.sms.entity;





import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
 

 
@Entity
@Table(name="course")
public class Course{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "coursename", nullable = false)
	private String coursename;
	
	
	@Column(name = "duration")
	private int duration;
	
	@OneToMany(mappedBy = "course" , cascade = CascadeType.ALL)
	private List <Student> student = new ArrayList<Student>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	public Course(Long id, String coursename, int duration, List<Student> student) {
		super();
		this.id = id;
		this.coursename = coursename;
		this.duration = duration;
		this.student = student;
	}

	public Course(){
		
	}
	
}
