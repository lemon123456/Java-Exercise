package com.tw.core.entity;

import javax.persistence.*;

/**
 * Created by twer on 7/17/15.
 */

@Entity
@Table(name = "Courses")
public class Courses {

    private int id;
    private String courseName;
    private Employee employee;
    private String time;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "courseName")
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="coachId")
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


    public Courses() {
    }

    public Courses(int id, String courseName, Employee employee, String time) {
        this.id = id;
        this.courseName = courseName;
        this.employee = employee;
        this.time = time;
    }
}
