package com.javainfinite.security.controller;

import com.javainfinite.security.model.Student;
import com.javainfinite.security.service.StudentService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private StudentService service;

    private PasswordEncoder encoder;

    public StudentController(StudentService service, PasswordEncoder encoder) {
        this.service = service;
        this.encoder = encoder;
    }

    /**
     * Any user can access this API - No Authentication required
     * @param student
     * @return
     */

    @PostMapping("/register")
    public Student registerStudent(@RequestBody Student student) {
        Student student1 = new Student();
        student1.setSname(student.getSname());
        student1.setPassword(encoder.encode(student.getPassword()));
        student1.setSrole(student.getSrole());
        return service.register(student1);
    }

    /**
     * User who has logged in successfully can access this API
     * @param username
     * @return
     */
    @GetMapping("/studentInfo")
    public Student getStudentInfo(@RequestParam("sname") String username) {
        return service.getDetails(username);
    }

    /**
     * User who has the role ROLE_WRITE can only access this API
     * @param username
     * @return
     */
    @GetMapping("/getStudentRoles")
    public String getStudentRoles(@RequestParam("sname") String username) {
        return service.getStudentRoles(username);
    }

    @GetMapping("/getAll")
    public String hola(){
        return "Acceso aprobado";
    }
}
