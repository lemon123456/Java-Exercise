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

    private int id;
    private String name;
    private String sex;
    private int age;
    private String password;
    private int employeeId;
//    private Employee employee;

    public User(){

    }

    public User(String name, String sex, int age, String password,int employeeId) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.password = password;
        this.employeeId = employeeId;
    }


    @Column(name = "id")
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


    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Column(name = "employeeId")
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="employeeId")
//    public Employee getEmployee() {
//        return employee;
//    }
//
//    public void setEmployee(Employee employee) {
//        this.employee = employee;
//    }
}





