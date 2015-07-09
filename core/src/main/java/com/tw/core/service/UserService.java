package com.tw.core.service;

import com.tw.core.Dao.UserDao;
import com.tw.core.entity.User;

import java.sql.SQLException;

/**
 * Created by twer on 7/8/15.
 */
public class UserService {

    UserDao userDao = new UserDao();

    public int insertUsers(String name, String sex, String email, int age){
        try {
           return userDao.insertUsers(name, sex, email, age);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  0;
    }

    public int deleteUsers(int id){
        try {
            return userDao.deleteUsers(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  0;
    }

    public User getOneUser(int id){
        try{
            return userDao.getOneUser(id);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public int UpdateOneUser(User user){
        try{
            return userDao.UpdateOneUser(user);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return 0;
    }

}
