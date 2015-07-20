package com.tw.core.controller;

import com.tw.core.Util.CookieUtil;
import com.tw.core.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by twer on 7/19/15.
 */

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method =RequestMethod.GET)
    public ModelAndView getEmployees(HttpSession session,HttpServletResponse response){

        if (session.getAttribute("user") != null) {
            System.out.println(employeeService.getEmployees()+"######################");
            return new ModelAndView("employee","employeeList",employeeService.getEmployees());
        } else {
            CookieUtil.saveCookie("previousURL", "/employee", response);
            return new ModelAndView("redirect:"+"/login");
        }
    }
}
