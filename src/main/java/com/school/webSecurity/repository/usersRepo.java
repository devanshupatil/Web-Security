package com.school.webSecurity.repository;

import com.school.webSecurity.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface usersRepo extends JpaRepository<Users, Integer> {

    Users findByUsername(String username);

    boolean existsByUsername(String username);
}
