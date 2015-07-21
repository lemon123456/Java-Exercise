package com.tw.core.controller;

import com.tw.core.Dao.CoursesDao;
import com.tw.core.Util.CookieUtil;
import com.tw.core.entity.Courses;
import com.tw.core.entity.Employee;
import com.tw.core.service.CourseService;
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
@RequestMapping("/courses")
public class CoursesController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method =RequestMethod.GET)
    public ModelAndView getCourses(HttpSession session,HttpServletResponse response){

        if (session.getAttribute("user") != null) {
            return new ModelAndView("courses","courseList",courseService.getCourses());
        } else {
            CookieUtil.saveCookie("previousURL", "/courses", response);
            return new ModelAndView("redirect:"+"/login");
        }
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteCourse(@PathVariable("id") String id,HttpSession session) throws SQLException {

        if (session.getAttribute("user") != null) {
            courseService.deleteCourse(Integer.parseInt(id));
            return new ModelAndView("redirect:" + "/courses");
        } else {
            return new ModelAndView("redirect:" + "/login");
        }
    }


    @RequestMapping(value = "/modify/{id}", method = RequestMethod.GET)
    public ModelAndView getOneCourse(@PathVariable("id") String id, HttpSession session) throws SQLException {

        if (session.getAttribute("user") != null) {
            return new ModelAndView("modifyCourse", "course",courseService.getOneCourse(Integer.parseInt(id)));
        } else {
            return new ModelAndView("redirect:" + "/login");
        }
    }

    @RequestMapping(value = "/modify/{id}", method = RequestMethod.POST)
    public ModelAndView updateOneCustomer(@PathVariable("id") String id,
                                          @RequestParam(value = "courseName") String courseName,
                                          @RequestParam(value = "coachId") int coachId,
                                          @RequestParam(value = "time") String time,
                                          HttpSession session) {
        if (session.getAttribute("user") != null) {

            Courses course = new Courses();
            course.setId(Integer.parseInt(id));
            course.setCourseName(courseName);
            Employee employee = employeeService.getOneEmployee(coachId);
            course.setEmployee(employee);
            course.setTime(time);

            courseService.updateOneCourse(course);
            return new ModelAndView("redirect:" + "/courses");
        } else {
            return new ModelAndView("redirect:" + "/login");
        }
    }


    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ModelAndView insertCourse(@RequestParam(value = "courseName") String courseName,
                                     @RequestParam(value = "coachId") int coachId,
                                     @RequestParam(value = "time") String time,
                                     HttpSession session) throws SQLException {

        if (session.getAttribute("user") != null) {

            Courses course = new Courses();
            course.setCourseName(courseName);
            Employee employee = employeeService.getOneEmployee(coachId);
            course.setEmployee(employee);
            course.setTime(time);

            courseService.insertCourse(course);

            return new ModelAndView("redirect:" + "/courses");
        } else {
            return new ModelAndView("redirect:" + "/login");
        }
    }


}
