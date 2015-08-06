package com.tw.core.entity;

import javax.persistence.*;

@Entity
@Table(name = "Schedule")
public class Schedule {
    private int id;
    private Course course;
    private Employee employee;
    private String time;
    private String customer;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "courseId")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @ManyToOne//(fetch = FetchType.LAZY)
    @JoinColumn(name = "coachId")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Column(name = "time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Column(name = "customer")
    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }


    public Schedule() {
    }

    public Schedule(Course course, Employee employee, String time, String customer) {
        this.course = course;
        this.employee = employee;
        this.time = time;
        this.customer = customer;
    }


    public Schedule(int id, Course course, Employee employee, String time, String customer) {
        this.id = id;
        this.course = course;
        this.employee = employee;
        this.time = time;
        this.customer = customer;
    }
}
