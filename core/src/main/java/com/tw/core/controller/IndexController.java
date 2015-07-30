package com.tw.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/")
public class IndexController {

//    response.setContentType("text/html;charset=utf-8");
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getIndex(){
        return new ModelAndView("index");
    }
}
