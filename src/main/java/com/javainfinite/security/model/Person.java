package com.javainfinite.security.model;

public class Person {

     private Long id;
     private String id_type;
     private String id_number;
     private String name;
     private String lastname;
     private String cellphone;
     private String email;
     private Integer level;
     private String username;
     private String password;
     private boolean active;

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getId_type() {
  return id_type;
 }

 public void setId_type(String id_type) {
  this.id_type = id_type;
 }

 public String getId_number() {
  return id_number;
 }

 public void setId_number(String id_number) {
  this.id_number = id_number;
 }

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public String getLastname() {
  return lastname;
 }

 public void setLastname(String lastname) {
  this.lastname = lastname;
 }

 public String getCellphone() {
  return cellphone;
 }

 public void setCellphone(String cellphone) {
  this.cellphone = cellphone;
 }

 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }

 public Integer getLevel() {
  return level;
 }

 public void setLevel(Integer level) {
  this.level = level;
 }

 public String getUsername() {
  return username;
 }

 public void setUsername(String username) {
  this.username = username;
 }

 public String getPassword() {
  return password;
 }

 public void setPassword(String password) {
  this.password = password;
 }

 public boolean isActive() {
  return active;
 }

 public void setActive(boolean active) {
  this.active = active;
 }
}
