package com.javainfinite.security.service;

import com.javainfinite.security.model.User;
import com.javainfinite.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User register(User user) {
        return userRepository.save(user);
    }

    public User getDetails(String username) {
        return userRepository.findBySname(username);
    }

    public String getStudentRoles(String username) {
        return userRepository.findBySname(username).getSrole();
    }

}
