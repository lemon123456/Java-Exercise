
package com.tw.core.controller;

import com.mysql.jdbc.StringUtils;
import com.tw.core.entity.User;
import com.tw.core.Dao.UserDao;

import java.io.*;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.*;

import com.tw.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;
    Map<String, Object> data = new HashMap<String, Object>();


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getLoginPage() {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView logIn(@RequestParam(value = "userName") String userName,
                              @RequestParam(value = "password") String password, HttpSession session) throws SQLException {

        if(userService.login(userName,password)){
            session.setAttribute("user", userName+password);
            return new ModelAndView("redirect:" + "/users");
        }

        return new ModelAndView("redirect:" + "/");
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getUsers(HttpSession session) {

        ModelAndView modelAndView = new ModelAndView();

        if (session.getAttribute("user") != null) {
            modelAndView.setViewName("user Information");
            return modelAndView;
        } else {
            return new ModelAndView("redirect:"+"/");
        }
    }

    @RequestMapping(value = "/users/insert", method = RequestMethod.GET)
    public ModelAndView insertUser(HttpSession session) throws SQLException {

        ModelAndView modelAndView = new ModelAndView();

        if (session.getAttribute("user") != null) {
            modelAndView.setViewName("insert");
            return modelAndView;
        } else {
            return new ModelAndView("redirect:"+"/");
        }
    }

    @RequestMapping(value = "/users/insert", method = RequestMethod.POST)
    public ModelAndView insertUser(@RequestParam(value = "name") String userName,
                                   @RequestParam(value = "sex") String userSex,
                                   @RequestParam(value = "email") String userEmail,
                                   @RequestParam(value = "age") int userAge,
                                   @RequestParam(value = "password") String userPassword, HttpSession session) throws SQLException {

        if (session.getAttribute("user") != null) {
            User user = new User();
            user.setName(userName);
            user.setSex(userSex);
            user.setEmail(userEmail);
            user.setAge(userAge);
            user.setPassword(userPassword);
            userService.insertUsers(user.getName(), user.getSex(), user.getEmail(), user.getAge(), user.getPassword());
            data.put("userList", userService.getUsers());
            return new ModelAndView("redirect:" + "/users");
        } else {
            return new ModelAndView("redirect:" + "/");
        }

    }


    @RequestMapping(value = "/users/delete", method = RequestMethod.GET)
    public ModelAndView deleteUser(@RequestParam(value = "id") int id, HttpSession session) throws SQLException {
        if (session.getAttribute("user") != null) {
            userService.deleteUsers(id);
            return new ModelAndView("redirect:" + "/users");
        } else {
            return new ModelAndView("redirect:" + "/");
        }
    }


    @RequestMapping(value = "/users/modify", method = RequestMethod.GET)
    public ModelAndView getOneUser(@RequestParam(value = "id") int id, HttpSession session) throws SQLException {
        if (session.getAttribute("user") != null) {
            data.put("userList", userService.getOneUser(id));
            return new ModelAndView("modify", data);
        } else {
            return new ModelAndView("redirect:"+"/");
        }
    }

    @RequestMapping(value = "/users/modify", method = RequestMethod.POST)
    public ModelAndView updateOneUser(@RequestParam(value = "userId") int userId,
                                      @RequestParam(value = "name") String userName,
                                      @RequestParam(value = "sex") String userSex,
                                      @RequestParam(value = "email") String userEmail,
                                      @RequestParam(value = "age") int userAge,
                                      @RequestParam(value = "password") String userPassword,HttpSession session) {
        if (session.getAttribute("user") != null) {
            User user = new User();
            user.setId(userId);
            user.setName(userName);
            user.setSex(userSex);
            user.setEmail(userEmail);
            user.setAge(userAge);
            user.setPassword(userPassword);
            userService.UpdateOneUser(user);
        return new ModelAndView("redirect:" + "/users");
        } else {
            return new ModelAndView("redirect:"+"/");
        }
    }


}