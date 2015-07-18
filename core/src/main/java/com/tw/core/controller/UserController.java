
package com.tw.core.controller;

import com.mysql.jdbc.StringUtils;
import com.tw.core.Util.CookieUtil;
import com.tw.core.entity.User;
import com.tw.core.Dao.UserDao;

import java.io.*;
import java.net.CookieStore;
import java.net.URLDecoder;
import java.sql.SQLException;
import java.util.*;

import com.tw.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;
    Map<String, Object> data = new HashMap<String, Object>();


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getLoginPage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView logIn(@RequestParam(value = "name") String name,
                              @RequestParam(value = "password") String password,
                              HttpSession session,
                              HttpServletRequest request,
                              HttpServletResponse response) throws SQLException {

        ModelAndView modelAndView = new ModelAndView();
        if (userService.login(name, password)) {
            session.setAttribute("user", name );

            String previousURL = CookieUtil.getCookie("previousURL", request);
            if (previousURL != null){

                CookieUtil.deleteCookie(request,response);

                return new ModelAndView("redirect:" + previousURL);
            }else{
                return new ModelAndView("redirect:"+"/users");
            }
        } else {
            modelAndView.setViewName("login");
            return modelAndView;
        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getUsers(HttpSession session,HttpServletResponse response) {

        if (session.getAttribute("user") != null) {
            return new ModelAndView("user Information","userList",userService.getUsers());
        } else {
            CookieUtil.saveCookie("previousURL", "/users", response);
            return new ModelAndView("redirect:"+"/");
        }

    }


    @RequestMapping(value = "/users/insert", method = RequestMethod.GET)
    public ModelAndView insertUser(HttpSession session,HttpServletResponse response) throws SQLException {

        ModelAndView modelAndView = new ModelAndView();

        if (session.getAttribute("user") != null) {
            modelAndView.setViewName("insert");
            return modelAndView;
        } else {
            CookieUtil.saveCookie("previousURL", "/users/insert", response);
            modelAndView.setViewName("redirect:"+"/");
            return modelAndView;
        }
    }

    @RequestMapping(value = "/users/insert", method = RequestMethod.POST)
    public ModelAndView insertUser(@RequestParam(value = "name") String userName,
                                   @RequestParam(value = "sex") String userSex,
                                   @RequestParam(value = "age") int userAge,
                                   @RequestParam(value = "password") String userPassword,
                                   @RequestParam(value = "employeeId") int employeeId,HttpSession session) throws SQLException {

        if (session.getAttribute("user") != null) {
            User user = new User(userName,userSex,userAge,userPassword,employeeId);
            userService.insertUsers(user);
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
    public ModelAndView getOneUser(@RequestParam(value = "id") int id, HttpSession session,HttpServletResponse response) throws SQLException {
        if (session.getAttribute("user") != null) {
            return new ModelAndView("modify", "user",userService.getOneUser(id));
        } else {
            return new ModelAndView("redirect:" + "/");
        }
    }

    @RequestMapping(value = "/users/modify", method = RequestMethod.POST)
    public ModelAndView updateOneUser(@RequestParam(value = "id") int userId,
                                      @RequestParam(value = "name") String userName,
                                      @RequestParam(value = "sex") String userSex,
                                      @RequestParam(value = "age") int userAge,
                                      @RequestParam(value = "password") String userPassword,
                                      @RequestParam(value = "employeeId") int employeeId,
                                      HttpSession session) {
        if (session.getAttribute("user") != null) {
            User user = new User();
            user.setId(userId);
            user.setName(userName);
            user.setSex(userSex);
            user.setAge(userAge);
            user.setPassword(userPassword);
            user.setEmployeeId(employeeId);
            userService.UpdateOneUser(user);
            return new ModelAndView("redirect:" + "/users");
        } else {
            return new ModelAndView("redirect:" + "/");
        }
    }

    @RequestMapping(value = "/users/logout", method = RequestMethod.GET)
    public ModelAndView destroySession(HttpServletRequest request){
        request.getSession().invalidate();
        return new ModelAndView("redirect:"+"/");
    }

}