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

        return usersList;
    }


    public void insertUsers(String name, String sex, String email, int age, String password) throws SQLException {

        Session session = getSessionFactory().openSession();

        User user = new User();
        user.setName(name);
        user.setSex(sex);
        user.setEmail(email);
        user.setAge(age);
        password = passwordEncryption.encodeByMD5(password);
        user.setPassword(password);

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
        User user = (User)session.get(User.class,id); //此处User是类名，而不是数据库的表名,select * 不写

        session.close();
        return user;
    }


    public void UpdateOneUser(User user) throws SQLException{

        Session session = getSessionFactory().openSession();

        User user_update = new User();
        if (null != user) {
            user_update.setId(user.getId());
            user_update.setName(user.getName());
            user_update.setSex(user.getSex());
            user_update.setEmail(user.getEmail());
            user_update.setAge(user.getAge());
            user_update.setPassword(passwordEncryption.encodeByMD5(user.getPassword()));

            session.beginTransaction();
            session.update(user_update);
            session.getTransaction().commit();
            session.close();
        }
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

        return  true;
    }

        public static void main(String agrs[]) {
        new UserDao().login("admin","123");
    }


 }
