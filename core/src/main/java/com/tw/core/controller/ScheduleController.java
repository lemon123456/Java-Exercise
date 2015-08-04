package com.tw.core.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tw.core.Util.HibernateProxyTypeAdapter;
import com.tw.core.entity.Coach;
import com.tw.core.entity.Schedule;
import com.tw.core.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/schedules")
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

    //    @RequestMapping(method = RequestMethod.GET)
//    public ModelAndView getSchedules(HttpSession session,HttpServletResponse response) {
//
//        if (session.getAttribute("user") != null) {
//            ModelAndView modelAndView = new ModelAndView();
//            modelAndView.setViewName("schedule");
//            modelAndView.addObject("scheduleList", scheduleService.getSchedules());
//            modelAndView.addObject("courseList", courseService.getCourses());
//            modelAndView.addObject("coachList",coachService.getCoaches());
//            modelAndView.addObject("customerList", customerService.getCustomers());
//            return modelAndView;
//        } else {
//            CookieUtil.saveCookie("previousURL", "/schedule", response);
//            return new ModelAndView("redirect:"+"/login");
//        }
//
//    }
    private Gson gson = new GsonBuilder()
            .enableComplexMapKeySerialization() //支持Map的key为复杂对象的形式
            .serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss:SSS")//时间转化为特定格式
            .setPrettyPrinting() //对json结果格式化.
            .setVersion(1.0)    //有的字段不是一开始就有的,会随着版本的升级添加进来,那么在进行序列化和返序列化的时候就会根据版本号来选择是否要序列化.
                    //@Since(版本号)能完美地实现这个功能.还的字段可能,随着版本的升级而删除,那么
                    //@Until(版本号)也能实现这个功能,GsonBuilder.setVersion(double)方法需要调用.
            .registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY)
            .create();

    @RequestMapping(method = RequestMethod.GET)
    public String getSchedules() {
        List<Schedule> scheduleList = scheduleService.getSchedules();
        return gson.toJson(scheduleList);
    }

    @RequestMapping(value = "/coaches", method = RequestMethod.GET)
    public String getCoaches() {
        List<Coach> coachList = coachService.getCoaches();
        return gson.toJson(coachList);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteSchedule(@RequestParam(value = "id") int id) {
        scheduleService.deleteSchedule(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addSchedule(@RequestParam(value = "courseId") int courseId,
                                    @RequestParam(value = "coachId") int coachId,
                                    @RequestParam(value = "time") String time,
                                    @RequestParam(value = "customer") String customer){

        Schedule schedule = new Schedule(courseService.getOneCourse(courseId), employeeService.getOneEmployee(coachId), time, customer);
        scheduleService.insertSchedule(schedule);
        return gson.toJson(schedule);
    }


//    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
//    public ModelAndView deleteSchedule(@PathVariable("id") String id,
//                                       HttpSession session) throws SQLException {
//        if (session.getAttribute("user") != null) {
//            scheduleService.deleteSchedule(Integer.parseInt(id));
//            return new ModelAndView("redirect:" + "/schedule");
//        } else {
//            return new ModelAndView("redirect:" + "/login");
//        }
//    }
//
//    @RequestMapping(value = "/insert", method = RequestMethod.POST)
//    public ModelAndView insertSchedule(@RequestParam(value = "courseId") int courseId,
//                                       @RequestParam(value = "coachId") int coachId,
//                                       @RequestParam(value = "time") String time,
//                                       @RequestParam(value = "customer") String customer,
//                                       HttpSession session) throws SQLException {
//
//        if (session.getAttribute("user") != null) {
//            Schedule schedule = new Schedule(courseService.getOneCourse(courseId), employeeService.getOneEmployee(coachId), time, customer);
//            scheduleService.insertSchedule(schedule);
//            return new ModelAndView("redirect:" + "/schedule");
//        } else {
//            return new ModelAndView("redirect:" + "/login");
//        }
//    }
//
//    @RequestMapping(value = "/modify/{id}", method = RequestMethod.GET)
//    public ModelAndView modifySchedule(@PathVariable("id") String id,
//                                       HttpSession session) throws SQLException {
//        if (session.getAttribute("user") != null) {
//            ModelAndView modelAndView = new ModelAndView();
//            modelAndView.setViewName("modifySchedule");
//            modelAndView.addObject("schedule", scheduleService.getOneSchedule(Integer.parseInt(id)));
//            modelAndView.addObject("courseList", courseService.getCourses());
//            modelAndView.addObject("coachList", coachService.getCoaches());
//            modelAndView.addObject("customerList", customerService.getCustomers());
//            return modelAndView;
//        } else {
//            return new ModelAndView("redirect:" + "/login");
//        }
//    }
//
//
//    @RequestMapping(value = "/modify/{id}", method = RequestMethod.POST)
//    public ModelAndView modifySchedule(@PathVariable("id") String id,
//                                       @RequestParam(value = "courseId") int courseId,
//                                       @RequestParam(value = "coachId") int coachId,
//                                       @RequestParam(value = "time") String time,
//                                       @RequestParam(value = "customer") String customer,
//                                       HttpSession session) throws SQLException {
//
//        if (session.getAttribute("user") != null) {
//            Schedule schedule = new Schedule(Integer.parseInt(id), courseService.getOneCourse(courseId), employeeService.getOneEmployee(coachId), time, customer);
//            scheduleService.updateOneSchedule(schedule);
//            return new ModelAndView("redirect:" + "/schedule");
//        } else {
//            return new ModelAndView("redirect:" + "/login");
//        }
//    }
}
