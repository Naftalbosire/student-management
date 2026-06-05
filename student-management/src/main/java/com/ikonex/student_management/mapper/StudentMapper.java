package com.ikonex.student_management.mapper;

import com.ikonex.student_management.dto.StudentDTO;
import com.ikonex.student_management.dto.StudentRequestDTO;
import com.ikonex.student_management.model.Student;

public class StudentMapper {

    // Entity to Response DTO
    public static StudentDTO toDTO(Student student) {
        return new StudentDTO(
                student.getId(),
                student.getName(),
                student.getEmail()
        );
    }

    // Request DTO to Entity
    public static Student toEntity(StudentRequestDTO dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        return student;
    }
}