package com.ikonex.student_management.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class StudentRequestDTO {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotNull(message = "ClassStreamId is required")
    private Long classStreamId;

    public StudentRequestDTO() {}

    public StudentRequestDTO(String name, String email, Long classStreamId) {
        this.name = name;
        this.email = email;
        this.classStreamId = classStreamId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Long getClassStreamId() {
        return classStreamId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setClassStreamId(Long classStreamId) {
        this.classStreamId = classStreamId;
    }
}