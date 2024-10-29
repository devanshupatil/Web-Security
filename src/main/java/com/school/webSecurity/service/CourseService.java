package com.school.webSecurity.service;

import com.school.webSecurity.model.Courses;
import com.school.webSecurity.model.Teacher;
import com.school.webSecurity.repository.CourseRepo;
import com.school.webSecurity.repository.TeachersRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Autowired
    private TeachersRepo teachersRepo;

    public ResponseEntity<Courses> createCourse(Courses course) {

        Teacher teacher = teachersRepo.findById(course.getTeacherId());
        if (teacher == null) {

            System.out.println("Teacher not found");
            return (ResponseEntity<Courses>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(courseRepo.save(course));
    }

    public ResponseEntity<Courses> updateCourse(Courses course) {

        Courses courses = courseRepo.findById(course.getId());

        if (courses == null) {

            return (ResponseEntity<Courses>) ResponseEntity.status(HttpStatus.NOT_FOUND);

        }

        courses.setName(course.getName());
        courses.setDescription(course.getDescription());

        return ResponseEntity.ok(courses);
    }

    public ResponseEntity<List<Courses>> getAllCourse() {

        List<Courses> course = courseRepo.findAll();

        if (course == null) {

            return (ResponseEntity<List<Courses>>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }

        return ResponseEntity.ok(course);
    }

    public ResponseEntity<Courses> getCourse(int courseId) {

        Courses courses = courseRepo.findById(courseId);

        if (courses == null) {

            return (ResponseEntity<Courses>) ResponseEntity.status(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(courses);
    }
}
