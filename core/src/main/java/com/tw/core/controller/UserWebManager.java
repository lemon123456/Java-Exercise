package com.tw.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by twer on 7/11/15.
 */
@Controller
@RequestMapping(value = "/log")
public class UserWebManager {
    @RequestMapping(value = "/user")
    public String userManagement(){
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

        return "user Information";
    }
}
