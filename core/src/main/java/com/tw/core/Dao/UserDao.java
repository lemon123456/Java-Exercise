package com.tw.core.Dao;

import com.tw.core.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by twer on 7/7/15.
 */



public class UserDao {

    public List<User> getUsers() throws SQLException {

        List<User> usersList = new ArrayList<User>();

        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        String sql = "SELECT * FROM userInfo";

        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);


        while (rs.next()) {

            User user = new User(rs.getInt("id"),rs.getString("name"), rs.getNString("sex"), rs.getNString("email"), rs.getInt("age"));
            usersList.add(user);
        }
        return usersList;
    }




    public User getOneUser(int id) throws SQLException{

        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        String sql = "SELECT * FROM userInfo WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        ResultSet rs = statement.executeQuery();

        User user = new User();
        if (rs.next()){
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setSex(rs.getString("sex"));
            user.setEmail(rs.getString("email"));
            user.setAge(rs.getInt("age"));
        }

        return user;
    }


    public int UpdateOneUser(User user) throws SQLException{

        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        String sql = "UPDATE userInfo SET name=?,sex=?,email=?,age=? WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1,user.getName());
        statement.setString(2,user.getSex());
        statement.setString(3,user.getEmail());
        statement.setInt(4,user.getAge());
        statement.setInt(5,user.getId());

        int rs = statement.executeUpdate();

        return rs;
    }

    public int insertUsers(String name, String sex, String email, int age) throws SQLException {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();

        Statement statement = connection.createStatement();
        String sql = "insert into userInfo (name,sex,email,age) values ('"+name+"','"+sex+"','"+email+"','"+age+"')";
        int result = statement.executeUpdate(sql);
//
//        String sql = "insert into userInfo(name,gender,mailbox,age) values(?,?,?,?,?)";
//        PreparedStatement sta = connection.prepareStatement(sql);
//        sta.setString(1, name);
//        sta.setString(2, sex);
//        sta.setString(3, email);
//        sta.setInt(4, age);
//        sta.close();
//        connection.close();
        return result;
    }


    public int deleteUsers(int id) throws SQLException {
        DBConnection dbConnection = new DBConnection();
        Connection connection = dbConnection.getConnection();


        String sql = "delete from userInfo where id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);

        int result = statement.executeUpdate();

        return result;

//        String sql = "delete from userInfo where id=?";
//        PreparedStatement st = connection.prepareStatement(sql);
//        st.setInt(1,id);
//        st.close();
//        connection.close();
    }






    public static void main(String[] args) throws SQLException {
        UserDao daos = new UserDao();
       System.out.println(daos.getOneUser(3));
    }
}
