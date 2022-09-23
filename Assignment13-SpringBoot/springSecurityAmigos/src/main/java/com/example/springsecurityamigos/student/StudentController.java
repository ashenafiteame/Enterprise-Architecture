package com.example.springsecurityamigos.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {
    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "asehnafi"),
            new Student(2, "maria"),
            new Student(3, "anna")
    );

    @GetMapping(path = "{id}")
    public Student getStudent(@PathVariable("id") Integer id) {
        return STUDENTS.stream()
                .filter(student -> id.equals(student.getsId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student" + id + "doesn't exist"));
    }
}
