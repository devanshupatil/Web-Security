package com.school.webSecurity.repository;

import com.school.webSecurity.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepo extends JpaRepository<Courses, Integer> {

    Courses findById(int id);
}
