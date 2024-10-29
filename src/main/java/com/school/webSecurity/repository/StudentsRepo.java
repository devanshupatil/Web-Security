package com.school.webSecurity.repository;

import com.school.webSecurity.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsRepo extends JpaRepository<Student, Integer> {

    Student findById(int id);

}
