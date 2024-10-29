package com.school.webSecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello {

    @GetMapping("/hello")
    public String Home() {
        return "Hello WebSecurity";
    }

    @GetMapping("/")
    public String index() {
        return "index"; // This corresponds to index.html in the templates folder
    }
}
