package com.tw.core.service;

import com.tw.core.Dao.UserDao;
import com.tw.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by twer on 7/8/15.
 */

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> getUsers(){
        try {
            return userDao.getUsers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

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
