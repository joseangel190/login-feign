package com.javainfinite.security.controller;

import com.javainfinite.security.model.Person;
import com.javainfinite.security.model.User;
import com.javainfinite.security.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin()
public class StudentController {

    private final UserService service;

    private final PasswordEncoder encoder;

    public StudentController(UserService service, PasswordEncoder encoder) {
        this.service = service;
        this.encoder = encoder;
    }

    @GetMapping
    public List<User> findAll(){
        return service.findAll();
    }

    // LOGINS
    @GetMapping("/login/user")
    public void loginUser(){
        System.out.println("login successful");
    }

    @GetMapping("/login/collaborator")
    public void loginCollaborator(){
        System.out.println("login successful");
    }

    @GetMapping("/login/admin")
    public void loginAdmin(){
        System.out.println("login successful");
    }

    @GetMapping("/logout")
    public String logout(){
        return "login failure";
    }


    @PostMapping("/register/user")
    public User registerStudent(@RequestBody User user) {
        User user1 = new User();
        user1.setSname(user.getSname());
        user1.setPassword(encoder.encode(user.getPassword()));
        return service.registerUser(user1);
    }

    @PostMapping("/register/collaborator")
    public User registerCollaborator(@RequestBody User user) {
        User user1 = new User();
        user1.setSname(user.getSname());
        user1.setPassword(encoder.encode(user.getPassword()));
        return service.registerCollaborator(user1);
    }

    @PostMapping("/register/admin")
    public User registerAdmin(@RequestBody User user) {
        User user1 = new User();
        user1.setSname(user.getSname());
        user1.setPassword(encoder.encode(user.getPassword()));
        return service.registerAdmin(user1);
    }

    @GetMapping("/info/{username}")
    public User getStudentInfo(@PathVariable String username) {
        return service.getDetails(username);
    }

    @GetMapping("/rol/{username}")
    public String getStudentRoles(@PathVariable String username) {
        return service.getStudentRoles(username);
    }

    @GetMapping("/user/{id}")
    public Person listById(@PathVariable Long id){
        return service.listByUser(id);
    }
}
