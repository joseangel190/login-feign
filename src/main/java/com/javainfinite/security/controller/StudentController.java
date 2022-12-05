package com.javainfinite.security.controller;

import com.javainfinite.security.model.Person;
import com.javainfinite.security.model.User;
import com.javainfinite.security.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class StudentController {

    private final UserService service;

    private final PasswordEncoder encoder;

    public StudentController(UserService service, PasswordEncoder encoder) {
        this.service = service;
        this.encoder = encoder;
    }

    /**
     * Any user can access this API - No Authentication required
     * @param user
     * @return
     */

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

    /**
     * User who has logged in successfully can access this API
     * @param username
     * @return
     */
    @GetMapping("/info/{username}")
    public User getStudentInfo(@PathVariable String username) {
        return service.getDetails(username);
    }

    /**
     * User who has the role ROLE_WRITE can only access this API
     * @param username
     * @return
     */
    @GetMapping("/rol/{username}")
    public String getStudentRoles(@PathVariable String username) {
        return service.getStudentRoles(username);
    }

    @GetMapping("/user/{id}")
    public Person listById(@PathVariable Long id){
        return service.listByUser(id);
    }
}
