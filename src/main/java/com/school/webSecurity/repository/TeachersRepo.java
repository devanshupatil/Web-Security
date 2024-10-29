package com.school.webSecurity.repository;

import com.school.webSecurity.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachersRepo extends JpaRepository<Teacher, Integer> {

    Teacher findById(int id);
}
