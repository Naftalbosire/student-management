package com.ikonex.student_management.classstream;

import jakarta.persistence.*;

@Entity
@Table(name = "class_streams")
public class ClassStream {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // e.g. Form 1A

    public ClassStream() {}

    public ClassStream(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}