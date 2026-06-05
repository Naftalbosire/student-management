package com.ikonex.student_management.classstream;

import com.ikonex.student_management.model.Student;
import com.ikonex.student_management.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassStreamService {

    private final ClassStreamRepository repository;
    private final StudentRepository studentRepository;

    public ClassStreamService(ClassStreamRepository repository,
                              StudentRepository studentRepository) {
        this.repository = repository;
        this.studentRepository = studentRepository;
    }


    public ClassStream create(ClassStream classStream) {
        return repository.save(classStream);
    }


    public List<ClassStream> getAll() {
        return repository.findAll();
    }


    public ClassStream getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ClassStream not found"));
    }


    public ClassStream update(Long id, ClassStream updated) {

        ClassStream cs = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("ClassStream not found"));

        cs.setName(updated.getName());

        return repository.save(cs);
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }


    public List<Student> getStudentsByClassStream(Long classStreamId) {
        return studentRepository.findByClassStreamId(classStreamId);
    }
}