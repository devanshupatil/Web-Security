package com.school.webSecurity.controller;

import com.school.webSecurity.model.Student;
import com.school.webSecurity.service.studentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class studentController {

    @Autowired
    private studentsService service;

    @PutMapping("/{studentId}")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<Student> updateInfo(@RequestBody Student student,
            @PathVariable(value = "studentId") int studentId) {

        student.setId(studentId);

        return service.updateInfo(student);
    }

    @GetMapping("/{studentId}")
    @PreAuthorize("hasRole('STUDENT')")
    public ResponseEntity<Student> getInfo(@PathVariable(value = "studentId") int studentId) {

        return service.getInfo(studentId);
    }

}
