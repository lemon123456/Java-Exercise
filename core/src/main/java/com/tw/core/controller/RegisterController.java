package com.tw.core.controller;

import com.tw.core.Util.CookieUtil;
import com.tw.core.entity.Employee;
import com.tw.core.entity.User;
import com.tw.core.service.EmployeeService;
import com.tw.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * Created by twer on 7/21/15.
 */

@Controller
@RequestMapping("/users/insert")
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView insertUser(HttpSession session,HttpServletResponse response) throws SQLException {

            return new ModelAndView("insert");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView insertUser(@RequestParam(value = "name") String userName,
                                   @RequestParam(value = "sex") String userSex,
                                   @RequestParam(value = "age") int userAge,
                                   @RequestParam(value = "password") String userPassword,
                                   @RequestParam(value = "employeeId") int employeeId,
                                   HttpSession session) throws SQLException {

        User user = new User();
        user.setName(userName);
        user.setSex(userSex);
        user.setAge(userAge);
        user.setPassword(userPassword);
        Employee employee = employeeService.getOneEmployee(employeeId);
        user.setEmployee(employee);

        if (userService.verifyRegister(user)){
            userService.insertUsers(user);
            return new ModelAndView("redirect:" + "/");
        }else {
            return new ModelAndView("redirect:" + "/users/insert");
        }

    }
}
