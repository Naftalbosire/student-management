package com.ikonex.student_management.service;

import com.ikonex.student_management.classstream.ClassStream;
import com.ikonex.student_management.classstream.ClassStreamRepository;
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
    private final ClassStreamRepository classStreamRepository;

    public StudentService(StudentRepository repository,
                          ClassStreamRepository classStreamRepository) {
        this.repository = repository;
        this.classStreamRepository = classStreamRepository;
    }


    public StudentDTO createStudent(StudentRequestDTO dto) {

        ClassStream classStream = classStreamRepository.findById(dto.getClassStreamId())
                .orElseThrow(() ->
                        new StudentNotFoundException("ClassStream not found with id: " + dto.getClassStreamId()));

        Student student = StudentMapper.toEntity(dto, classStream);

        Student saved = repository.save(student);

        return StudentMapper.toDTO(saved);
    }


    public List<StudentDTO> getAllStudents() {
        return repository.findAll()
                .stream()
                .map(StudentMapper::toDTO)
                .collect(Collectors.toList());
    }


    public StudentDTO getStudentById(Long id) {

        Student student = repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with id: " + id));

        return StudentMapper.toDTO(student);
    }


    public StudentDTO updateStudent(Long id, StudentRequestDTO dto) {

        Student student = repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with id: " + id));

        student.setName(dto.getName());
        student.setEmail(dto.getEmail());

        ClassStream classStream = classStreamRepository.findById(dto.getClassStreamId())
                .orElseThrow(() ->
                        new StudentNotFoundException("ClassStream not found with id: " + dto.getClassStreamId()));

        student.setClassStream(classStream);

        Student updated = repository.save(student);

        return StudentMapper.toDTO(updated);
    }


    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}