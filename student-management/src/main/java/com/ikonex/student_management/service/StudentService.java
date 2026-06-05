package com.ikonex.student_management.service;

import com.ikonex.student_management.dto.StudentDTO;
import com.ikonex.student_management.dto.StudentRequestDTO;
import com.ikonex.student_management.exception.StudentNotFoundException;
import com.ikonex.student_management.mapper.StudentMapper;
import com.ikonex.student_management.model.Student;
import com.ikonex.student_management.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    
    public StudentDTO createStudent(StudentRequestDTO dto) {

        Student student = StudentMapper.toEntity(dto);

        Student saved = repository.save(student);

        return StudentMapper.toDTO(saved);
    }

  
    public List<StudentDTO> getAllStudents() {
        return repository.findAll()
                .stream()
                .map(StudentMapper::toDTO)
                .collect(Collectors.toList());
    
    public StudentDTO getStudentById(Long id) {

        Student student = repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with id: " + id));

        return StudentMapper.toDTO(student);
    }

    // (DTO to Entity to DTO)
    public StudentDTO updateStudent(Long id, StudentRequestDTO dto) {

        Student student = repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with id: " + id));

        student.setName(dto.getName());
        student.setEmail(dto.getEmail());

        Student updated = repository.save(student);

        return StudentMapper.toDTO(updated);
    }

    // (no DTO needed)
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}