package com.tw.core.controller;

import com.tw.core.Util.CookieUtil;
import com.tw.core.entity.Course;
import com.tw.core.service.CourseService;
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

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;


    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getCourses(HttpSession session,HttpServletResponse response){

        if (session.getAttribute("user") != null) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("course");
            modelAndView.addObject("courseList", courseService.getCourses());
            return modelAndView;
        } else {
            CookieUtil.saveCookie("previousURL", "/customer", response);
            return new ModelAndView("redirect:"+"/login");
        }
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ModelAndView insertUser(@RequestParam(value = "courseName") String courseName,
                                   @RequestParam(value = "description") String description,
                                   HttpSession session) throws SQLException {

        if (session.getAttribute("user") != null) {

            Course course = new Course(courseName,description);
            courseService.insertCourse(course);

            return new ModelAndView("redirect:" + "/course");
        } else {
            return new ModelAndView("redirect:" + "/login");
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteCustomer(@PathVariable("id") String id,HttpSession session) throws SQLException {
        if (session.getAttribute("user") != null) {
            courseService.deleteCourse(Integer.parseInt(id));
            return new ModelAndView("redirect:" + "/course");
        } else {
            return new ModelAndView("redirect:" + "/login");
        }
    }

    @RequestMapping(value = "/modify/{id}", method = RequestMethod.GET)
    public ModelAndView getOneCustomer(@PathVariable("id") String id, HttpSession session) throws SQLException {

        if (session.getAttribute("user") != null) {
            return new ModelAndView("modifyCourse", "course",courseService.getOneCourse(Integer.parseInt(id)));
        } else {
            return new ModelAndView("redirect:" + "/login");
        }
    }

    @RequestMapping(value = "/modify/{id}", method = RequestMethod.POST)
    public ModelAndView updateOneCustomer(@PathVariable("id") String id,
                                          @RequestParam(value = "courseName") String courseName,
                                          @RequestParam(value = "description") String description,
                                          HttpSession session) {


        if (session.getAttribute("user") != null) {

            Course course = new Course(Integer.parseInt(id),courseName,description);
            courseService.updateOneCourse(course);

            return new ModelAndView("redirect:" + "/course");
        } else {
            return new ModelAndView("redirect:" + "/login");
        }
    }
}
