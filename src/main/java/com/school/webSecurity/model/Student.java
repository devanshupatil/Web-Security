package com.school.webSecurity.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String subject;
    private String Class;
    private int marks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getstudentClass() {
        return Class;
    }

    public void setClass(String class1) {
        Class = class1;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", subject=" + subject + ", Class=" + Class + ", marks=" + marks
                + "]";
    }

}
