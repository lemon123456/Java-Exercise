package com.tw.core.service;

import com.tw.core.Dao.CoursesDao;
import com.tw.core.entity.Courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


/**
 * Created by twer on 7/21/15.
 */

@Service
public class CourseService {

    @Autowired
    private CoursesDao courseDao;

    public List<Courses> getCourses(){
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

    public Courses getOneCourse(int id){
        try{
            return courseDao.getOneCourse(id);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void updateOneCourse(Courses course){
        try{
            courseDao.updateOneCourse(course);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void insertCourse(Courses customer){
        try {
            courseDao.insertCourse(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
