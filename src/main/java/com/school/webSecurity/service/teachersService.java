package com.school.webSecurity.service;

import com.school.webSecurity.model.Student;
import com.school.webSecurity.model.Teacher;
import com.school.webSecurity.repository.StudentsRepo;
import com.school.webSecurity.repository.TeachersRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class teachersService {

    @Autowired
    private TeachersRepo repo;

    @Autowired
    private StudentsRepo studentsRepo;

    public ResponseEntity<Teacher> signup(Teacher teacher) {

        Teacher teachers = repo.findById(teacher.getId());

        if (teachers == null) {

            return (ResponseEntity<Teacher>) ResponseEntity.status(HttpStatus.NOT_FOUND);

        }

        teachers.setName(teacher.getName());
        teachers.setSubject(teacher.getSubject());
        teachers.setAddress(teacher.getAddress());
        repo.save(teachers);

        return ResponseEntity.ok(teacher);
    }

    public ResponseEntity<List<Student>> getAllStudents() {

        List<Student> student = studentsRepo.findAll();

        if (student == null) {
            return (ResponseEntity<List<Student>>) ResponseEntity.status(HttpStatus.NOT_FOUND);

        }
        return ResponseEntity.ok(student);
    }

    public ResponseEntity<Teacher> verify(Teacher teacher) {

        Teacher teacher2 = repo.findById(teacher.getId());

        if (teacher2 != null) {

            return ResponseEntity.ok(teacher2);

        }

        return (ResponseEntity<Teacher>) ResponseEntity.status(HttpStatus.NOT_FOUND);

    }
}
