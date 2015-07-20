package com.tw.core.controller;

import com.tw.core.Util.CookieUtil;
import com.tw.core.entity.Employee;
import com.tw.core.entity.User;
import com.tw.core.service.EmployeeService;
import com.tw.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

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
            return new ModelAndView("employee","employeeList",employeeService.getEmployees());
        } else {
            CookieUtil.saveCookie("previousURL", "/employee", response);
            return new ModelAndView("redirect:"+"/login");
        }
    }

    @RequestMapping(value = "/insert",method = RequestMethod.GET)
    public ModelAndView insertEmployee(HttpSession session,HttpServletResponse response){

        if (session.getAttribute("user") != null) {
            return new ModelAndView("insertEmployee");
        } else {
            CookieUtil.saveCookie("previousURL", "/employee/insert", response);
            return new ModelAndView("redirect:"+"/login");
        }
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ModelAndView insertUser(@RequestParam(value = "name") String name,
                                   @RequestParam(value = "role") String role,
                                   HttpSession session) throws SQLException {

        if (session.getAttribute("user") != null) {

            Employee employee = new Employee();
            employee.setName(name);
            employee.setRole(role);

            employeeService.insertEmployee(employee);
            return new ModelAndView("redirect:" + "/employee");
        } else {
            return new ModelAndView("redirect:" + "/login");
        }
    }

    @RequestMapping(value = "/modify/{id}", method = RequestMethod.GET)
    public ModelAndView getOneEmployee(@PathVariable("id") String id, HttpSession session) throws SQLException {

        if (session.getAttribute("user") != null) {
            int idd = Integer.parseInt(id);
            System.out.println(idd);
            return new ModelAndView("modifyEmployee", "employee",employeeService.getOneEmployee(idd));
        } else {
            return new ModelAndView("redirect:" + "/login");
        }
    }

    @RequestMapping(value = "/modify/{id}", method = RequestMethod.POST)
    public ModelAndView updateOneUser(@PathVariable("id") String idd,
                                      @RequestParam(value = "name") String name,
                                      @RequestParam(value = "role") String role,
                                      HttpSession session) {


        if (session.getAttribute("user") != null) {
            Employee employee = new Employee();
            employee.setId(Integer.parseInt(idd));
            employee.setName(name);
            employee.setRole(role);

            employeeService.UpdateOneEmployee(employee);
            return new ModelAndView("redirect:" + "/employee");
        } else {
            return new ModelAndView("redirect:" + "/login");
        }
    }

}
