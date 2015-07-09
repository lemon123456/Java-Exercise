package com.tw.web;

import com.tw.core.Dao.UserDao;
import com.tw.core.entity.User;
import com.tw.core.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by twer on 7/8/15.
 */
@WebServlet(name = "InsertServlet")
public class InsertServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));

//        User user = new User(id,name,sex,email,age);

        UserService userService = new UserService();
        if (userService.insertUsers(name,sex,email,age)>0){
            response.sendRedirect("/web/hello");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
