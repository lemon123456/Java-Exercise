package com.tw.core.entity;

/**
 * Created by twer on 7/7/15.
 */
    public class User {
    private int id;
    private String name;
    private String sex;
    private String email;
    private int age;

    public User(int id, String name, String sex, String email, int age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.email = email;
        this.age = age;
    }

    public User(){

    }

    public int getId(){return id;}
    public void setId(int id){this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}



