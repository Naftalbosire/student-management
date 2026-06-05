// package com.ikonex.student_management;

// import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication
// public class StudentManagementApplication {

// 	public static void main(String[] args) {
// 		SpringApplication.run(StudentManagementApplication.class, args);
// 	}

// }
package com.ikonex.student_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.ikonex.student_management")
@EnableJpaRepositories("com.ikonex.student_management")
public class StudentManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentManagementApplication.class, args);
    }
}