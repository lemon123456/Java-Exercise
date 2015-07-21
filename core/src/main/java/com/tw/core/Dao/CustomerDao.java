package com.tw.core.Dao;

import com.tw.core.entity.Customer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

import static com.tw.core.Util.HibernateUtil.getSessionFactory;

/**
 * Created by twer on 7/21/15.
 */

@Repository
public class CustomerDao {

    public List<Customer> getCustomers() throws SQLException {

        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Customer"); //此处User是类名，而不是数据库的表名,select * 不写
        List<Customer> customerList = query.list();
        session.getTransaction().commit();
        session.close();
        return customerList;
    }


    public void insertCustomer(Customer customer) throws SQLException {

        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
        session.close();
    }



    public void deleteCustomer(int id) throws SQLException {

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        Customer customer = new Customer();
        customer.setId(id);
        session.delete(customer);
        session.getTransaction().commit();

        session.close();
    }


    public Customer getOneCustomer(int id) throws SQLException{

        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Customer customer = (Customer)session.get(Customer.class,id);

        session.close();
        return customer;
    }

    public void UpdateOneCustomer(Customer customer) throws SQLException{

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        session.update(customer);
        session.getTransaction().commit();
        session.close();
    }



    public static void main(String arg[]) throws SQLException{
        CustomerDao customerDao = new CustomerDao();
        System.out.println(customerDao.getCustomers()+"!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
