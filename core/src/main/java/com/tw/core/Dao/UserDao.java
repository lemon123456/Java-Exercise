package com.tw.core.Dao;

import com.tw.core.Util.HibernateUtil;
import com.tw.core.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by twer on 7/7/15.
 */



public class UserDao {


    public List<User> getUsers() throws SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from User"); //此处User是类名，而不是数据库的表名,select * 不写
        List<User> usersList = query.list();


        return usersList;

    }

    public void insertUsers(String name, String sex, String email, int age) throws SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();

        User user = new User();
        user.setName(name);
        user.setSex(sex);
        user.setEmail(email);
        user.setAge(age);

        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();



    }


    public void deleteUsers(int id) throws SQLException {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        User user = new User();
        user.setId(id);
        session.delete(user);
        session.getTransaction().commit();

    }






    public User getOneUser(int id) throws SQLException{

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        User user = (User)session.get(User.class,id); //此处User是类名，而不是数据库的表名,select * 不写






//        DBConnection dbConnection = new DBConnection();
//        Connection connection = dbConnection.getConnection();
//
//        String sql = "FROM User WHERE id=?";
//        PreparedStatement statement = connection.prepareStatement(sql);
//        statement.setInt(1, id);
//
//        ResultSet rs = statement.executeQuery();
//
//        User user = new User();
//        if (rs.next()){
//            user.setId(rs.getInt("id"));
//            user.setName(rs.getString("name"));
//            user.setSex(rs.getString("sex"));
//            user.setEmail(rs.getString("email"));
//            user.setAge(rs.getInt("age"));
//        }

        return user;
    }


    public void UpdateOneUser(User user) throws SQLException{

        Session session = HibernateUtil.getSessionFactory().openSession();

        User user_update = new User();
        if (null != user) {
            user_update.setId(user.getId());
            user_update.setName(user.getName());
            user_update.setSex(user.getSex());
            user_update.setEmail(user.getEmail());
            user_update.setAge(user.getAge());

            session.beginTransaction();
            session.update(user_update);
            session.getTransaction().commit();
        }

    }




//    public static void main(String[] args) throws SQLException {
//        UserDao daos = new UserDao();
//        daos.getUsers();
//    }


 }
