package com.tw.core.Dao;

import com.tw.core.entity.Employee;
import com.tw.core.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

import static com.tw.core.Util.HibernateUtil.getSessionFactory;

@Repository
public class UserDao {

    public List<User> getUsers() throws SQLException {

        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from User"); //此处User是类名，而不是数据库的表名,select * 不写
        List<User> usersList = query.list();
        session.close();
        return usersList;
    }


    public boolean verifyRegister(User user) throws SQLException{

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        Employee employee = user.getEmployee();

        if (employee == null){
            System.out.println("++++++++++++++++++++++++++该工号不存在++++++++++++++++++++");
            return  false;
        }else{

            int coachId = employee.getId();
            Query query = session.createQuery("SELECT count(*) FROM User user where user.employee.id = :coachId");
            query.setParameter("coachId", coachId);
            Long count = (Long)query.uniqueResult();

            if (count != 0){
                System.out.println("+++++++++++++++++++++++++++该工号已占用+++++++++++++++++++++");
                return false;
            }else{
                return  true;
            }
        }
    }
    public void insertUsers(User user) throws SQLException {

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        session.save(user);

        session.getTransaction().commit();
        session.close();
    }


    public void deleteUsers(int id) throws SQLException {

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        User user = new User();
        user.setId(id);
        session.delete(user);
        session.getTransaction().commit();

        session.close();
    }



    public User getOneUser(int id) throws SQLException{

        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        User user = (User)session.get(User.class,id);

        session.close();
        return user;
    }


    public void UpdateOneUser(User user) throws SQLException{

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        session.update(user);
        session.getTransaction().commit();
        session.close();
    }


    public boolean login (String name, String password) throws SQLException{

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

//        password = passwordEncryption.encodeByMD5(password);

        Query query = session.createQuery("SELECT count(*) FROM User user where user.name = :name and user.password = :password");
        query.setParameter("name", name);
        query.setParameter("password",password);

        Long count = (Long)query.uniqueResult();
        System.out.println(count);
        if (count == 0){
            return false;
        }

        session.getTransaction().commit();
        session.close();
        return  true;
    }


    public static void main(String agrs[]) throws SQLException{
        UserDao userdao = new UserDao();
        System.out.println(userdao.login("admin1", "123"));
    }


 }
