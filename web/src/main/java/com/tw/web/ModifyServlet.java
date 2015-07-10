package com.tw.web;

import com.tw.core.entity.User;
import com.tw.core.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by twer on 7/8/15.
 */
@WebServlet(name = "ModifyServlet")
public class ModifyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String email = request.getParameter("email");
        int age = Integer.parseInt(request.getParameter("age"));

        User user = new User(id,name,sex,email,age);

        UserService userService = new UserService();
        userService.UpdateOneUser(user);
        response.sendRedirect("/web/hello"); /*远程定向，重定向*/


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        UserService userService = new UserService();
        User user = userService.getOneUser(id);

        request.setAttribute("userList", user);

        request.getRequestDispatcher("modify.jsp").forward(request, response); /*直接跳转，请求转发*/

       // response.sendRedirect("/modify");
    }
}
