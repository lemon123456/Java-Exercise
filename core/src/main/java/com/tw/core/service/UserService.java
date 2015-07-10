package com.tw.core.service;

import com.tw.core.Dao.UserDao;
import com.tw.core.entity.User;

import java.sql.SQLException;

/**
 * Created by twer on 7/8/15.
 */
public class UserService {

    UserDao userDao = new UserDao();

    public void insertUsers(String name, String sex, String email, int age){
        try {
            userDao.insertUsers(name, sex, email, age);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUsers(int id){
        try {
            userDao.deleteUsers(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }






    public User getOneUser(int id){
        try{
            return userDao.getOneUser(id);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void UpdateOneUser(User user){
        try{
            userDao.UpdateOneUser(user);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

}
