package com.example.database.dao;

import com.example.database.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Integer>{
    Student findByCourseName(String courseName);
}
