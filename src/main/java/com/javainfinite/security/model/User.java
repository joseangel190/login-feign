package com.javainfinite.security.model;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "username")
    private String sname;

    @Column(name = "password")
    private String password;

    @Column(name = "roles")
    private String srole;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSrole() {
        return srole;
    }

    public void setSrole(String srole) {
        this.srole = srole;
    }

    public User() {
    }

    public User(Integer id, String sname, String password, String srole) {
        this.id = id;
        this.sname = sname;
        this.password = password;
        this.srole = srole;
    }
}
