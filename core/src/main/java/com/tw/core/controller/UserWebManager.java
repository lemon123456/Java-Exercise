




package com.tw.core.controller;

import com.tw.core.entity.User;
import com.tw.core.Dao.UserDao;
import java.io.*;
import java.sql.SQLException;
import java.util.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserWebManager {

    UserDao userDao = new UserDao();
    Map<String,Object> data = new HashMap<String,Object>();


    @RequestMapping("/")
    public ModelAndView userPage(){
        return new ModelAndView("user Information");
    }

    @RequestMapping("/insert")
    public ModelAndView addUser(@RequestParam(value = "name")String userName,
                                @RequestParam(value = "sex")String userSex,
                                @RequestParam(value = "email")String userEmail,
                                @RequestParam(value = "age")int userAge) throws SQLException {
        User user = new User();
        user.setName(userName);
        user.setSex(userSex);
        user.setEmail(userEmail);
        user.setAge(userAge);

        userDao.insertUsers(user.getName(), user.getSex(), user.getEmail(), user.getAge());

        data.put("userList", userDao.getUsers());
        return new ModelAndView("user Information",data);
    }



    @RequestMapping("/delete")
    public ModelAndView deleteUser(@RequestParam(value = "id")int id) throws SQLException {
        userDao.deleteUsers(id);
        data.put("userList", userDao.getUsers());
        return new ModelAndView("user Information",data);
    }



    @RequestMapping(value = "/modify",method=RequestMethod.GET)
    public ModelAndView getOneUser(@RequestParam(value = "id")int id) throws SQLException{
        data.put("userList",userDao.getOneUser(id));
        return new ModelAndView("modify",data);

    }

    @RequestMapping(value="/modify",method=RequestMethod.POST)
    public ModelAndView updateOneUser( @RequestParam(value = "id")int userId,
                                       @RequestParam(value = "name")String userName,
                                       @RequestParam(value = "sex")String userSex,
                                       @RequestParam(value = "email")String userEmail,
                                       @RequestParam(value = "age")int userAge) throws SQLException{

        User user = new User();
        user.setId(userId);
        user.setName(userName);
        user.setSex(userSex);
        user.setEmail(userEmail);
        user.setAge(userAge);

        userDao.UpdateOneUser(user);
        data.put("userList", userDao.getUsers());
        return new ModelAndView("user Information",data);
    }


}