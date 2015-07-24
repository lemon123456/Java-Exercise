package com.tw.core.entity;

import javax.persistence.*;


@Entity
@Table(name = "Employee")
public class Employee {
    private int id;
    private String name;
    private String sex;
    private int age;
    private String email;
    private String role;
    private String state;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Column(name = "age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "role")
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    @Column(name = "state")
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Employee() {
    }

    public Employee(String name, String sex, int age, String email, String role, String state) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.email = email;
        this.role = role;
        this.state = state;
    }

    public Employee(int id, String name, String sex, int age, String email, String role, String state) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.email = email;
        this.role = role;
        this.state = state;
    }
}
