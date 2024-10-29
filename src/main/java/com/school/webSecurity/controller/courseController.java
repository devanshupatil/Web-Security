package com.school.webSecurity.controller;

import com.school.webSecurity.model.Courses;
import com.school.webSecurity.service.CourseService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/courses")
public class courseController {

    @Autowired
    private CourseService service;

    @PreAuthorize("hasRole('TEACHER')")
    @PostMapping("/{teachersId}")
    public ResponseEntity<Courses> createCourse(@RequestBody Courses course,
            @PathVariable(value = "teachersId") int teacherId) {

        course.setTeacherId(teacherId);

        return service.createCourse(course);

    }

    @PreAuthorize("hasRole('TEACHER')")
    @PutMapping("/{teachersId}")
    public ResponseEntity<Courses> updateCourse(@RequestBody Courses course,
            @PathVariable(value = "teachersId") int teacherId) {

        course.setTeacherId(teacherId);

        return service.updateCourse(course);

    }

    @GetMapping
    @PreAuthorize("hasRole('TEACHER') or hasRole('STUDENT')")
    public ResponseEntity<List<Courses>> getAllCourse() {
        return service.getAllCourse();
    }

    @GetMapping("/{courseId}")
    @PreAuthorize("hasRole('TEACHER') or hasRole('STUDENT')")
    public ResponseEntity<Courses> getCourse(@PathVariable(value = "courseId") int courseId) {

        return service.getCourse(courseId);
    }
}
