package com.tw.core.controller;

import com.tw.core.Util.CookieUtil;
import com.tw.core.entity.Schedule;
import com.tw.core.service.*;
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
@RequestMapping("/schedule")
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private CoachService coachService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getSchedules(HttpSession session,HttpServletResponse response) {

        if (session.getAttribute("user") != null) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("schedule");
            modelAndView.addObject("scheduleList", scheduleService.getSchedules());
            modelAndView.addObject("courseList", courseService.getCourses());
            modelAndView.addObject("coachList",coachService.getCoaches());
            modelAndView.addObject("customerList", customerService.getCustomers());
            return modelAndView;
        } else {
            CookieUtil.saveCookie("previousURL", "/schedule", response);
            return new ModelAndView("redirect:"+"/login");
        }

    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteSchedule(@PathVariable("id") String id,
                                   HttpSession session) throws SQLException {
        if (session.getAttribute("user") != null) {
            scheduleService.deleteSchedule(Integer.parseInt(id));
            return new ModelAndView("redirect:" + "/schedule");
        } else {
            return new ModelAndView("redirect:" + "/login");
        }
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ModelAndView insertSchedule(@RequestParam(value = "courseId") int courseId,
                                       @RequestParam(value = "coachId") int coachId,
                                       @RequestParam(value = "time") String time,
                                       @RequestParam(value = "customer") String customer,
                                       HttpSession session) throws SQLException {

        if (session.getAttribute("user") != null) {
            Schedule schedule = new Schedule(courseService.getOneCourse(courseId),employeeService.getOneEmployee(coachId),time,customer);
            scheduleService.insertSchedule(schedule);
            return new ModelAndView("redirect:" + "/schedule");
        } else {
            return new ModelAndView("redirect:" + "/login");
        }
    }

    @RequestMapping(value = "/modify/{id}", method = RequestMethod.GET)
    public ModelAndView modifySchedule(@PathVariable("id") String id,
                                       HttpSession session) throws SQLException {
        if (session.getAttribute("user") != null) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("modifySchedule");
            modelAndView.addObject("schedule", scheduleService.getOneSchedule(Integer.parseInt(id)));
            modelAndView.addObject("courseList",courseService.getCourses());
            modelAndView.addObject("coachList",coachService.getCoaches());
            modelAndView.addObject("customerList",customerService.getCustomers());
            return modelAndView;
        } else {
            return new ModelAndView("redirect:" + "/login");
        }
    }


    @RequestMapping(value = "/modify/{id}", method = RequestMethod.POST)
    public ModelAndView modifySchedule(@PathVariable("id") String id,
                                       @RequestParam(value = "courseId") int courseId,
                                       @RequestParam(value = "coachId") int coachId,
                                       @RequestParam(value = "time") String time,
                                       @RequestParam(value = "customer") String customer,
                                       HttpSession session) throws SQLException {

        if (session.getAttribute("user") != null) {
            Schedule schedule = new Schedule(Integer.parseInt(id),courseService.getOneCourse(courseId),employeeService.getOneEmployee(coachId),time,customer);
            scheduleService.updateOneSchedule(schedule);
            return new ModelAndView("redirect:" + "/schedule");
        } else {
            return new ModelAndView("redirect:" + "/login");
        }
    }
}
