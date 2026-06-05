package com.ikonex.student_management.mapper;

import com.ikonex.student_management.classstream.ClassStream;
import com.ikonex.student_management.dto.StudentDTO;
import com.ikonex.student_management.dto.StudentRequestDTO;
import com.ikonex.student_management.model.Student;

public class StudentMapper {

    // Entity → DTO
    public static StudentDTO toDTO(Student student) {
        return new StudentDTO(
                student.getId(),
                student.getName(),
                student.getEmail()
        );
    }

    // DTO → Entity
    public static Student toEntity(StudentRequestDTO dto, ClassStream classStream) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setClassStream(classStream);
        return student;
    }
}