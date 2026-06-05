package com.ikonex.student_management.classstream;

import com.ikonex.student_management.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class-streams")
@CrossOrigin
public class ClassStreamController {

    private final ClassStreamService service;

    public ClassStreamController(ClassStreamService service) {
        this.service = service;
    }

    @PostMapping
    public ClassStream create(@RequestBody ClassStream classStream) {
        return service.create(classStream);
    }

    @GetMapping
    public List<ClassStream> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ClassStream getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public ClassStream update(
            @PathVariable Long id,
            @RequestBody ClassStream classStream) {

        return service.update(id, classStream);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/{id}/students")
    public List<Student> getStudentsByClassStream(@PathVariable Long id) {
        return service.getStudentsByClassStream(id);
    }
}