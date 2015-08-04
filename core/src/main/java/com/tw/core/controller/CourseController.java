package com.tw.core.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tw.core.Util.HibernateProxyTypeAdapter;
import com.tw.core.entity.Course;
import com.tw.core.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    private Gson gson = new GsonBuilder()
//            .excludeFieldsWithoutExposeAnnotation() //不导出实体中没有用@Expose注解的属性
            .enableComplexMapKeySerialization() //支持Map的key为复杂对象的形式
            .serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss:SSS")//时间转化为特定格式
//                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)//会把字段首字母大写,注:对于实体上使用了@SerializedName注解的不会生效.
            .setPrettyPrinting() //对json结果格式化.
            .setVersion(1.0)    //有的字段不是一开始就有的,会随着版本的升级添加进来,那么在进行序列化和返序列化的时候就会根据版本号来选择是否要序列化.
                    //@Since(版本号)能完美地实现这个功能.还的字段可能,随着版本的升级而删除,那么
                    //@Until(版本号)也能实现这个功能,GsonBuilder.setVersion(double)方法需要调用.
            .registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY)
            .create();

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody String getCourses(){
        List<Course> courseList = courseService.getCourses();
        return gson.toJson(courseList);
    }


//
//    @RequestMapping(method = RequestMethod.GET)
//    public @ResponseBody List<Course> getCourses() {
//
//        List<Course> courseList = courseService.getCourses();
//        return courseList;
//
//    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Course insertCourse(@RequestParam(value = "courseName") String courseName,
                             @RequestParam(value = "description") String description) {
        Course course = new Course(courseName, description);
        courseService.insertCourse(course);
        return course;
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
    public
    @ResponseBody
    void deleteCourse(@PathVariable int id) {
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


    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public @ResponseBody Course updateOneCourse(@RequestParam(value = "id") int id,
                                                @RequestParam(value = "courseName") String courseName,
                                                @RequestParam(value = "description") String description) {

        Course course = new Course(id, courseName, description);
        courseService.updateOneCourse(course);
//        System.out.println(course.getId());
//        System.out.println(course.getCourseName());
//        System.out.println(course.getDescription());
//        course = courseService.getOneCourse(id);

//            JSONObject courseJson = new JSONObject("{'id':'"+course.getId()+
//                    "','courseName':'" + course.getCourseName() +
//                    "','description':'" + course.getDescription()+"'}");
//            response.setContentType("text/html;charset=utf-8");
//            response.getWriter().write(courseJson.toString());
        return course;
    }
}
