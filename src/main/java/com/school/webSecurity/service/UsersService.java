package com.school.webSecurity.service;

import com.school.webSecurity.model.Student;
import com.school.webSecurity.model.Teacher;
import com.school.webSecurity.model.Users;
import com.school.webSecurity.repository.StudentsRepo;
import com.school.webSecurity.repository.TeachersRepo;
import com.school.webSecurity.repository.usersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private usersRepo usersRepo;

    @Autowired
    private StudentsRepo sRepo;

    @Autowired
    private TeachersRepo tRepo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public ResponseEntity<Users> signup(Users user) {

        if (usersRepo.existsByUsername(user.getUsername())) {

            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(user);
            // "Username already exists!";
        }
        // add student or teacher by to check the role

        user.setPassword(encoder.encode(user.getPassword()));
        usersRepo.save(user);
        if ("STUDENT".equals(user.getRole())) {

            Student students = new Student();
            // students.setUserId(user.getId());
            sRepo.save(students);

            user.setId(students.getId());

        } else if ("TEACHER".equals(user.getRole())) {
            Teacher teacher = new Teacher();
            // teacher.setUserId(user.getId());

            tRepo.save(teacher);
            user.setId(teacher.getId());
        }
        // return JSON from
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<Users> verify(Users user) {

        Users users = usersRepo.findByUsername(user.getUsername());

        if (users != null) {

            return ResponseEntity.ok(users);

        }
        return (ResponseEntity<Users>) ResponseEntity.status(401);

    }
}
