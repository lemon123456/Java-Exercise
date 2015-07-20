package com.tw.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by twer on 7/19/15.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getCustomer(){
        return new ModelAndView("customer");
    }
}
