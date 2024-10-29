package com.school.webSecurity.controller;

import com.school.webSecurity.model.Users;
import com.school.webSecurity.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/signup")
public class UserController {

    @Autowired
    private UsersService service;

    @PostMapping
    public ResponseEntity<Users> signup(@RequestBody Users user) {

        user.setRole(user.getRole().toUpperCase());

        return service.signup(user);

    }

    @PostMapping("/login")
    public ResponseEntity<Users> login(@RequestBody Users user) {

        return service.verify(user);
        // return userId
    }

}
