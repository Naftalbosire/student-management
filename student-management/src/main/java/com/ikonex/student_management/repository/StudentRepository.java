package com.ikonex.student_management.repository;

import com.ikonex.student_management.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}