package com.javainfinite.security.service;

import com.javainfinite.security.feignclient.PersonClient;
import com.javainfinite.security.model.Person;
import com.javainfinite.security.model.User;
import com.javainfinite.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PersonClient personClient;

    public User registerUser(User user) {
        user.setSrole("ROLE_USER");
        return userRepository.save(user);
    }

    public User registerCollaborator(User user) {
        user.setSrole("ROLE_COLLABORATOR");
        return userRepository.save(user);
    }

    public User registerAdmin(User user) {
        user.setSrole("ROLE_ADMIN");
        return userRepository.save(user);
    }

    public User getDetails(String username) {
        return userRepository.findBySname(username);
    }

    public Person listByUser(Long id){
        return personClient.listById(id);
    }

    public String getStudentRoles(String username) {
        return userRepository.findBySname(username).getSrole();
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }


}
