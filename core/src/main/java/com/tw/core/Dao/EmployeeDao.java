package com.tw.core.Dao;

import com.tw.core.entity.Employee;
import com.tw.core.entity.User;
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
public class EmployeeDao {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Employee> getEmployees() throws SQLException {

//        Session session = getSessionFactory().openSession();
//        session.beginTransaction();
//        Query query = session.createQuery("from Employee"); //此处User是类名，而不是数据库的表名,select * 不写
//        List<Employee> employeeList = query.list();
//        session.close();

        List<Employee> employeeList = sessionFactory.getCurrentSession().createQuery("from Employee").list();
        return employeeList;
    }


    public void insertEmployee(Employee employee) throws SQLException {

//        Session session = getSessionFactory().openSession();
//        session.beginTransaction();
//        session.save(employee);
//        session.getTransaction().commit();
//        session.close();

        sessionFactory.getCurrentSession().save(employee);
    }




    public Employee getOneEmployee(int id) throws SQLException{

//        Session session = getSessionFactory().openSession();
//        session.beginTransaction();
//        Employee employee = (Employee)session.get(Employee.class,id);
//
//        session.close();

        Employee employee = (Employee)sessionFactory.getCurrentSession().get(Employee.class, id);
        return employee;
    }


    public void UpdateOneEmployee(Employee employee) throws SQLException{

//        Session session = getSessionFactory().openSession();
//        session.beginTransaction();
//
//        session.update(employee);
//        session.getTransaction().commit();
//        session.close();

        sessionFactory.getCurrentSession().update(employee);
    }

}
