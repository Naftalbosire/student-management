package com.ikonex.student_management.repository;

import com.ikonex.student_management.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByClassStreamId(Long classStreamId);
}