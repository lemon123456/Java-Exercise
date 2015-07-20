package com.tw.core.Dao;

import com.tw.core.entity.Employee;
import com.tw.core.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

import static com.tw.core.Util.HibernateUtil.getSessionFactory;

/**
 * Created by twer on 7/19/15.
 */

@Repository
public class EmployeeDao {

    public List<Employee> getEmployees() throws SQLException {

        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Employee"); //此处User是类名，而不是数据库的表名,select * 不写
        List<Employee> employeeList = query.list();
        session.close();
        return employeeList;
    }


//    public void inserEmployee(Employee employee) throws SQLException {
//
//        Session session = getSessionFactory().openSession();
//        session.beginTransaction();
//
//        session.save(employee);
//        session.getTransaction().commit();
//        session.close();
//    }
//
//
//    public void deleteEmployee(int id) throws SQLException {
//
//        Session session = getSessionFactory().openSession();
//        session.beginTransaction();
//
//        Employee employee = new Employee();
//        employee.setId(id);
//        session.delete(employee);
//        session.getTransaction().commit();
//
//        session.close();
//    }
//
//
//
//    public Employee getOneEmployee(int id) throws SQLException{
//
//        Session session = getSessionFactory().openSession();
//        session.beginTransaction();
//        Employee employee = (Employee)session.get(Employee.class,id);
//
//        session.close();
//        return employee;
//    }
//
//
//    public void UpdateOneEmployee(Employee employee) throws SQLException{
//
//        Session session = getSessionFactory().openSession();
//        session.beginTransaction();
//
//        session.update(employee);
//        session.getTransaction().commit();
//        session.close();
//    }


    public static void main(String arg[]) throws SQLException{
        EmployeeDao employeeDao = new EmployeeDao();
        System.out.println(employeeDao.getEmployees());
    }

}
