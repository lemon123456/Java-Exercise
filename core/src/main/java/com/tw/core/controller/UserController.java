




package com.tw.core.controller;

import com.tw.core.entity.User;
import com.tw.core.Dao.UserDao;
import java.io.*;
import java.sql.SQLException;
import java.util.*;

import com.tw.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class UserController {


    @Autowired
    private UserService userService;

    Map<String,Object> data = new HashMap<String,Object>();

    @RequestMapping(value="/login",method = RequestMethod.GET)
    public ModelAndView logIn(){
        return new ModelAndView("login");
    }



    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView getUsers(){
        return new ModelAndView("user Information");
    }



    @RequestMapping(value = "/insert",method = RequestMethod.GET)
    public ModelAndView insertUser() throws SQLException {
        return new ModelAndView("insert");
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public ModelAndView insertUser(@RequestParam(value = "name")String userName,
                                   @RequestParam(value = "sex")String userSex,
                                   @RequestParam(value = "email")String userEmail,
                                   @RequestParam(value = "age")int userAge) throws SQLException {
        User user = new User();
        user.setName(userName);
        user.setSex(userSex);
        user.setEmail(userEmail);
        user.setAge(userAge);

        userService.insertUsers(user.getName(), user.getSex(), user.getEmail(), user.getAge());

        data.put("userList", userService.getUsers());
        return new ModelAndView("user Information",data);
    }



    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public ModelAndView deleteUser(@RequestParam(value = "id")int id) throws SQLException {
        userService.deleteUsers(id);
        data.put("userList", userService.getUsers());
        return new ModelAndView("user Information",data);
    }



    @RequestMapping(value = "/modify",method=RequestMethod.GET)
    public ModelAndView getOneUser(@RequestParam(value = "id")int id) throws SQLException{
        data.put("userList",userService.getOneUser(id));
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

        userService.UpdateOneUser(user);
        data.put("userList", userService.getUsers());
        return new ModelAndView("user Information",data);
    }


}