package com.tw.core.Dao;

import com.tw.core.entity.Courses;
import com.tw.core.entity.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import static com.tw.core.Util.HibernateUtil.getSessionFactory;
import java.util.List;

/**
 * Created by twer on 7/21/15.
 */

@Repository
public class CoursesDao {

    public List<Courses> getCourses() throws SQLException {

        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Courses"); //此处User是类名，而不是数据库的表名,select * 不写
        List<Courses> courseList = (List<Courses>) query.list();
        session.getTransaction().commit();
        session.close();
        return courseList;
    }

    public void deleteCourse(int id) throws SQLException {

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        Courses course = new Courses();
        course.setId(id);
        session.delete(course);
        session.getTransaction().commit();

        session.close();
    }


    public Courses getOneCourse(int id) throws SQLException{

        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Courses course = (Courses)session.get(Courses.class,id);

        session.close();
        return course;
    }


    public void updateOneCourse(Courses course) throws SQLException{

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        session.update(course);
        session.getTransaction().commit();
        session.close();
    }


    public void insertCourse(Courses course) throws SQLException {

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        Employee employee = course.getEmployee();
        int coachId = employee.getId();
        String time = course.getTime();

        Query query = session.createQuery("SELECT count(*) FROM Courses course where course.employee.id = :coachId and course.time = :time");
        System.out.println("right");
        query.setParameter("coachId", coachId);
        query.setParameter("time", time);

        Long count = (Long)query.uniqueResult();

        if (count != 0){
            System.out.println("+++++++++++++++++++++++++++时间冲突+++++++++++++++++++++");
        }else{
            session.save(course);
            System.out.println("++++++++++++++++++++++++++插入课程成功++++++++++++++++++++");
        }

        session.getTransaction().commit();
        session.close();

    }

//    public static void main(String arg[]) throws SQLException{
//        CoursesDao courseDao = new CoursesDao();
//
//        Employee employee = new Employee("李三","COACH");
//        employee.setId(3);
//        Courses course = new Courses();
//        course.setCourseName("run");
//        course.setEmployee(employee);
//        course.setTime("星期一");
//
//        System.out.println(courseDao.insertCourse(course));
//    }
}
