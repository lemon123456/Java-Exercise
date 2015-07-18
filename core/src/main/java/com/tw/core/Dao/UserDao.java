package com.tw.core.Dao;

import com.tw.core.Util.HibernateUtil;
import com.tw.core.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.tw.core.Util.HibernateUtil.*;


/**
 * Created by twer on 7/7/15.
 */


@Repository
public class UserDao {

    PasswordEncryption passwordEncryption = new PasswordEncryption();

    public List<User> getUsers() throws SQLException {

        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from User"); //此处User是类名，而不是数据库的表名,select * 不写
        List<User> usersList = query.list();
        session.close();
        return usersList;
    }


    public void insertUsers(User user) throws SQLException {

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        User user_insert = new User();
        user_insert.setId(user.getId());
        user_insert.setName(user.getName());
        user_insert.setSex(user.getSex());
        user_insert.setAge(user.getAge());
        user_insert.setPassword(passwordEncryption.encodeByMD5(user.getPassword()));
        user_insert.setEmployeeId(user.getEmployeeId());

        session.save(user_insert);
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

        User user_update = new User();
        user_update.setId(user.getId());
        user_update.setName(user.getName());
        user_update.setSex(user.getSex());
        user_update.setAge(user.getAge());
        user_update.setPassword(user.getPassword());
        user_update.setEmployeeId(user.getEmployeeId());

        session.update(user_update);
        session.getTransaction().commit();
        session.close();
    }


    public boolean login (String name, String password){

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        password = passwordEncryption.encodeByMD5(password);

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


    public static void main(String agrs[]) {
        UserDao userdao = new UserDao();
        userdao.login("admin1","123");
    }


 }
