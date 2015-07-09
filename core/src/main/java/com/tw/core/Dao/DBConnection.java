package com.tw.core.Dao;

import com.tw.core.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by twer on 7/7/15.
 */
public class DBConnection {

    public Connection getConnection() {

        Connection connection = null;
        String driver = "com.mysql.jdbc.Driver"; //驱动名称
        String url = "jdbc:mysql://localhost:3306/userInfo?useUnicode=true&characterEncoding=UTF-8";//url指向要访问的数据库

        try {
            Class.forName(driver);//加载驱动程序
            connection = DriverManager.getConnection(url, "root", "");//链接数据库

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args){
        System.out.print(new DBConnection().getConnection());}

}
