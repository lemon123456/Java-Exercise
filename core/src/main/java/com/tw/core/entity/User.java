package com.tw.core.entity;
import javax.persistence.*;

/**
 * Created by twer on 7/7/15.
 */



    @Entity
    @Table(name = "userInfo")


    public class User {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id") // 非必要，在欄位名稱與屬性名稱不同時使用
    private int id;

    @Column(name = "name") // 非必要，在欄位名稱與屬性名稱不同時使用
    private String name;

    @Column(name = "sex") // 非必要，在欄位名稱與屬性名稱不同時使用
    private String sex;

    @Column(name = "email") // 非必要，在欄位名稱與屬性名稱不同時使用
    private String email;

    @Column(name = "age") // 非必要，在欄位名稱與屬性名稱不同時使用
    private int age;

    // 必須要有一個預設的建構方法
    // 以使得Hibernate可以使用Constructor.newInstance()建立物件
    public User() {
    }

    public User(int id, String name, String sex, String email, int age) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.email = email;
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }



    public int getId() {
        return id;

    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}
//    public class User {
//    private int id;
//    private String name;
//    private String sex;
//    private String email;
//    private int age;
//
//    public User(int id, String name, String sex, String email, int age) {
//        this.id = id;
//        this.name = name;
//        this.sex = sex;
//        this.email = email;
//        this.age = age;
//    }
//
//    public User(){
//
//    }
//
//    public int getId(){return id;}
//    public void setId(int id){this.id = id;}
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSex() {
//        return sex;
//    }
//
//    public void setSex(String sex) {
//        this.sex = sex;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//}



