package com.tw.core.entity;

import javax.persistence.*;

/**
 * Created by twer on 7/17/15.
 */

@Entity
@Table(name = "CourseTime")
public class CourseTime {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private int id;
    @Column(name = "courseId")
    private int courseId;
    @Column(name = "courseTime")
    private String courseTime;

    public CourseTime() {
    }

    public CourseTime(int courseId, String courseTime) {
        this.courseId = courseId;
        this.courseTime = courseTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }
}
