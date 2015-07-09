package com.tw.web;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.*;

import com.tw.core.Dao.UserDao;
import com.tw.core.entity.User;

public class HelloServlet extends HttpServlet {
    public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

    //    PrintWriter out = res.getWriter();


        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;character=utf-8");


        try {
            req.getRequestDispatcher("user Information.jsp").forward(req,res);
        } catch (Exception e) {
            e.printStackTrace();
        }


     //   out.println(new Service().service());
     //   out.close();
    }
}