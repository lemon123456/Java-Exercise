package com.tw.core.controller;

import com.tw.core.Util.CookieUtil;
import com.tw.core.entity.Customer;
import com.tw.core.entity.Employee;
import com.tw.core.entity.User;
import com.tw.core.service.CustomerService;
import com.tw.core.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * Created by twer on 7/19/15.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method =RequestMethod.GET)
    public ModelAndView getCustomers(HttpSession session,HttpServletResponse response){

        if (session.getAttribute("user") != null) {
            return new ModelAndView("customer","customerList",customerService.getCustomers());
        } else {
            CookieUtil.saveCookie("previousURL", "/customer", response);
            return new ModelAndView("redirect:"+"/login");
        }
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ModelAndView insertUser(@RequestParam(value = "customerName") String customerName,
                                   @RequestParam(value = "coachId") int coachId,
                                   HttpSession session) throws SQLException {

        if (session.getAttribute("user") != null) {

            Customer customer = new Customer();
            customer.setCustomerName(customerName);
            Employee employee = employeeService.getOneEmployee(coachId);
            customer.setEmployee(employee);
            customerService.insertCustomer(customer);

            return new ModelAndView("redirect:" + "/customer");
        } else {
            return new ModelAndView("redirect:" + "/login");
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteCustomer(@PathVariable("id") String id,HttpSession session) throws SQLException {
        if (session.getAttribute("user") != null) {
            customerService.deleteCustomer(Integer.parseInt(id));
            return new ModelAndView("redirect:" + "/customer");
        } else {
            return new ModelAndView("redirect:" + "/login");
        }
    }

    @RequestMapping(value = "/modify/{id}", method = RequestMethod.GET)
    public ModelAndView getOneCustomer(@PathVariable("id") String id, HttpSession session) throws SQLException {

        if (session.getAttribute("user") != null) {
            return new ModelAndView("modifyCustomer", "customer",customerService.getOneCustomer(Integer.parseInt(id)));
        } else {
            return new ModelAndView("redirect:" + "/login");
        }
    }

    @RequestMapping(value = "/modify/{id}", method = RequestMethod.POST)
    public ModelAndView updateOneCustomer(@PathVariable("id") String id,
                                          @RequestParam(value = "customerName") String customerName,
                                          @RequestParam(value = "coachId") int coachId,
                                          HttpSession session) {


        if (session.getAttribute("user") != null) {

            Customer customer = new Customer();
            customer.setId(Integer.parseInt(id));
            customer.setCustomerName(customerName);
            Employee employee = employeeService.getOneEmployee(coachId);
            customer.setEmployee(employee);
            customerService.UpdateOneCustomer(customer);

            return new ModelAndView("redirect:" + "/customer");
        } else {
            return new ModelAndView("redirect:" + "/login");
        }
    }

}
