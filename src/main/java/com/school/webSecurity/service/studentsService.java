package com.school.webSecurity.service;

import com.school.webSecurity.model.Student;
import com.school.webSecurity.repository.StudentsRepo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;

@Service
public class studentsService {

    @Autowired
    private StudentsRepo studentsRepo;

    public ResponseEntity<Student> updateInfo(Student students) {

        System.out.println("\n" + students);

        Student student = studentsRepo.findById(students.getId());

        if (student == null) {

            return (ResponseEntity<Student>) ResponseEntity.status(401);
        }

        student.setName(students.getName());
        student.setMarks(students.getMarks());
        student.setSubject(students.getSubject());
        student.setClass(student.getstudentClass());

        studentsRepo.save(students);

        return ResponseEntity.ok(students);
    }

    public ResponseEntity<Student> getInfo(int studentId) {

        Student student = studentsRepo.findById(studentId);

        if (student != null) {

            return ResponseEntity.ok(student);
        }

        return (ResponseEntity<Student>) ResponseEntity.status(401);

    }
}
