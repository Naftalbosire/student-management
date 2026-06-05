package com.ikonex.student_management.controller;

import com.ikonex.student_management.dto.StudentDTO;
import com.ikonex.student_management.dto.StudentRequestDTO;
import com.ikonex.student_management.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@CrossOrigin
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping
    public StudentDTO create(@Valid @RequestBody StudentRequestDTO dto) {
        return service.createStudent(dto);
    }

    @GetMapping
    public List<StudentDTO> getAll() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentDTO getById(@PathVariable Long id) {
        return service.getStudentById(id);
    }

    @PutMapping("/{id}")
    public StudentDTO update(
            @PathVariable Long id,
            @Valid @RequestBody StudentRequestDTO dto) {

        return service.updateStudent(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteStudent(id);
    }
}