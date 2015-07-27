package com.tw.core.controller;

import com.tw.core.Util.CookieUtil;
import com.tw.core.entity.Course;
import com.tw.core.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    public ModelAndView getCourses() {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("course");
        modelAndView.addObject("courseList", courseService.getCourses());
        return modelAndView;

    }


    @RequestMapping(method = RequestMethod.POST)
    public void insertCourse(@RequestParam(value = "courseName") String courseName,
                             @RequestParam(value = "description") String description) throws SQLException {

        Course course = new Course(courseName, description);
        courseService.insertCourse(course);
    }

//    @RequestMapping(value = "/insert", method = RequestMethod.POST)
//    public ModelAndView insertCourse(@RequestParam(value = "courseName") String courseName,
//                                   @RequestParam(value = "description") String description,
//                                   HttpSession session) throws SQLException {
//
//        if (session.getAttribute("user") != null) {
//
//            Course course = new Course(courseName,description);
//            courseService.insertCourse(course);
//
//            return new ModelAndView("redirect:" + "/course");
//        } else {
//            return new ModelAndView("redirect:" + "/login");
//        }
//    }



    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
    }


//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//    public ModelAndView deleteCourse(@PathVariable("id") String id,HttpSession session) throws SQLException {
//        if (session.getAttribute("user") != null) {
//            courseService.deleteCourse(Integer.parseInt(id));
//            return new ModelAndView("redirect:" + "/course");
//        } else {
//            return new ModelAndView("redirect:" + "/login");
//        }
//    }

//    @RequestMapping(value = "/modify/{id}", method = RequestMethod.GET)
//    public ModelAndView getOneCourse(@PathVariable("id") String id, HttpSession session) throws SQLException {
//
//        if (session.getAttribute("user") != null) {
//            return new ModelAndView("modifyCourse", "course", courseService.getOneCourse(Integer.parseInt(id)));
//        } else {
//            return new ModelAndView("redirect:" + "/login");
//        }
//    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void updateOneCourse(@PathVariable("id") String id,
                                @RequestParam(value = "courseName") String courseName,
                                @RequestParam(value = "description") String description) {

            Course course = new Course(Integer.parseInt(id), courseName, description);
            courseService.updateOneCourse(course);
    }
}
