package com.school.webSecurity.model;

import jakarta.persistence.*;

@Entity
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String description;
    private int teacherId;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

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

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Override
    public String toString() {
        return "Courses [id=" + id + ", name=" + name + ", description=" + description + ", teacherId=" + teacherId
                + "]";
    }

}
