package com.tw.core.service;

import com.tw.core.Dao.CourseDao;
import com.tw.core.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseDao courseDao;

    public List<Course> getCourses(){
        try {
            return courseDao.getCourses();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteCourse(int id){
        try {
            courseDao.deleteCourse(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Course getOneCourse(int id){
        try{
            return courseDao.getOneCourse(id);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void updateOneCourse(Course course){
        try{
            courseDao.UpdateOneCourse(course);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void insertCourse(Course course){
        try {
            courseDao.insertCourse(course);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
