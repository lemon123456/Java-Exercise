package com.tw.core.controller;

import com.tw.core.Util.CookieUtil;
import com.tw.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

/**
 * Created by twer on 7/18/15.
 */

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;


    @RequestMapping( method = RequestMethod.GET)
    public ModelAndView getLoginPage() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }


    @RequestMapping( method = RequestMethod.POST)
    public ModelAndView logIn(@RequestParam(value = "name") String name,
                              @RequestParam(value = "password") String password,
                              HttpSession session,
                              HttpServletRequest request,
                              HttpServletResponse response) throws SQLException {

        if (userService.login(name, password)) {
            session.setAttribute("user", name );

            String previousURL = CookieUtil.getCookie("previousURL", request);
            if (previousURL != null){

                CookieUtil.deleteCookie(request,response);

                return new ModelAndView("redirect:" + previousURL);
            }else{
                return new ModelAndView("redirect:"+"/users");
            }
        } else {
            return new ModelAndView("loginError");
        }
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ModelAndView destroySession(HttpServletRequest request){
        request.getSession().invalidate();
        return new ModelAndView("redirect:"+"/login");
    }
}
