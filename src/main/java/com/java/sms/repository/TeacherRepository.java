package com.java.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.sms.entity.Teacher;

@Repository
public interface TeacherRepository  extends JpaRepository<Teacher, Long>{

}
