package com.tw.core.entity;

import javax.persistence.*;

@Entity
@Table(name = "Course")
public class Course {

    private int id;
    private String courseName;
    private String description;

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

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Course() {
    }

    public Course(int id, String courseName, String description) {
        this.id = id;
        this.courseName = courseName;
        this.description = description;
    }

    public Course(String courseName, String description) {
        this.courseName = courseName;
        this.description = description;
    }
}
