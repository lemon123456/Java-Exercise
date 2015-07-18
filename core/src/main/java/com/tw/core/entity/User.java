package com.tw.core.entity;
import javax.persistence.*;

/**
 * Created by twer on 7/7/15.
 */

@Entity //@Entity 注解将一个类声明为实体 Bean
@Table(name = "User")

public class User {

    @Id //@Id 注解声明了该实体Bean的标识属性
    @GeneratedValue(strategy = GenerationType.AUTO)  //@Id 注解可将实体Bean中某个属性定义为主键，使用@GenerateValue注解可以定义该标识符的生成策略。

    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "sex")
    private String sex;
    @Column(name = "age")
    private int age;
    @Column(name = "password")
    private String password;
    @Column(name = "employeeId")
    private int employeeId;

    public User() {
    }

    public User(String name, String sex, int age, String password, int employeeId) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.password = password;
        this.employeeId = employeeId;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}





