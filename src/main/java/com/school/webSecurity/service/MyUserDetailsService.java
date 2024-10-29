package com.school.webSecurity.service;

import com.school.webSecurity.model.*;
import com.school.webSecurity.repository.usersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private usersRepo uRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users user = uRepo.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return new usersDetails(user);
    }

}
