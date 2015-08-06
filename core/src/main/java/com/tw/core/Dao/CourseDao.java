package com.tw.core.Dao;

import com.tw.core.entity.Course;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.List;

import static com.tw.core.Util.HibernateUtil.getSessionFactory;

@Repository
@Transactional
@EnableTransactionManagement
public class CourseDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Course> getCourses() throws SQLException {

//        Session session = getSessionFactory().openSession();
//        session.beginTransaction();
//
//        Query query = session.createQuery("from Course"); //此处User是类名，而不是数据库的表名,select * 不写
//        List<Course> courseList = query.list();
//
//        session.getTransaction().commit();
//        session.close();

        List<Course> courseList = sessionFactory.getCurrentSession().createQuery("from Course").list();
        return courseList;
    }


    public void insertCourse(Course course) throws SQLException {

//        Session session = getSessionFactory().openSession();
//        session.beginTransaction();
//
//        session.save(course);
//
//        session.getTransaction().commit();
//        session.close();

        sessionFactory.getCurrentSession().save(course);
    }



    public void deleteCourse(int id) throws SQLException {

//        Session session = getSessionFactory().openSession();
//        session.beginTransaction();
//
        Course course = new Course();
        course.setId(id);
//        session.delete(course);
//
//        session.getTransaction().commit();
//        session.close();

        sessionFactory.getCurrentSession().delete(course);
    }


    public Course getOneCourse(int id) throws SQLException{

//        Session session = getSessionFactory().openSession();
//        session.beginTransaction();
//        Course course = (Course)session.get(Course.class,id);
//
//        session.close();

        Course course = (Course)sessionFactory.getCurrentSession().get(Course.class,id);
        return course;
    }

    public void UpdateOneCourse(Course course) throws SQLException{
//
//        Session session = getSessionFactory().openSession();
//        session.beginTransaction();
//
//        session.update(course);
//        session.getTransaction().commit();
//        session.close();

        sessionFactory.getCurrentSession().update(course);
    }

}
