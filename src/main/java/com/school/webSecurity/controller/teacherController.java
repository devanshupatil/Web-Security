package com.school.webSecurity.controller;

import com.school.webSecurity.model.Student;
import com.school.webSecurity.model.Teacher;
import com.school.webSecurity.service.teachersService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teachers")
public class teacherController {

    @Autowired
    private teachersService service;

    @PreAuthorize("hasRole('TEACHER')")
    @PutMapping("{teacherId}")
    public ResponseEntity<Teacher> signup(@RequestBody Teacher teacher,
            @PathVariable(value = "teacherId") int teacherId) {

        teacher.setId(teacherId);

        return service.signup(teacher);
    }

    @PreAuthorize("hasRole('TEACHER')")
    @GetMapping("{teacherId}")
    public ResponseEntity<Teacher> login(@RequestBody Teacher teacher,
            @PathVariable(value = "teacherId") int teacherId) {

        teacher.setId(teacherId);

        return service.verify(teacher);
    }

    @PreAuthorize("hasRole('TEACHER')")
    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudents() {

        return service.getAllStudents();
    }

}
