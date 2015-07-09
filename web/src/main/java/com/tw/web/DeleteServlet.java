package com.tw.web;

import com.tw.core.entity.User;
import com.tw.core.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by twer on 7/8/15.
 */
@WebServlet(name = "DeleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int id = Integer.parseInt(request.getParameter("id"));
        UserService userService = new UserService();
        if (userService.deleteUsers(id)>0){
            response.sendRedirect("/web/hello");
//            HelloServlet s = new HelloServlet();
//            s.doGet(request, response);
        }


//        String name = request.getParameter("name");
//        String sex = request.getParameter("sex");
//        String email = request.getParameter("email");
//        int age = Integer.parseInt(request.getParameter("age"));
//
//        User user = new User(name,sex,email,age);
//
//        UserService userService = new UserService();
//       if (userService.deleteUsers(name)){
//            response.sendRedirect("/web");
//        }
    }

}
