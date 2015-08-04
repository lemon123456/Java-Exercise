package com.tw.core.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tw.core.Util.CookieUtil;
import com.tw.core.Util.HibernateProxyTypeAdapter;
import com.tw.core.entity.Customer;
import com.tw.core.entity.Employee;
import com.tw.core.entity.User;
import com.tw.core.service.CoachService;
import com.tw.core.service.CustomerService;
import com.tw.core.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CoachService coachService;

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

    @RequestMapping(method =RequestMethod.GET)
    public @ResponseBody String getCustomers(HttpSession session,HttpServletResponse response){

        List<Customer> customerList = customerService.getCustomers();
        response.setContentType("text/html;charset=utf-8");
        return gson.toJson(customerList);

//        if (session.getAttribute("user") != null) {
//            ModelAndView modelAndView = new ModelAndView();
//            modelAndView.setViewName("customer");
//            modelAndView.addObject("customerList", customerService.getCustomers());
//            modelAndView.addObject("coachList",coachService.getCoaches());
//            return modelAndView;
//        } else {
//            CookieUtil.saveCookie("previousURL", "/customer", response);
//            return new ModelAndView("redirect:"+"/login");
//        }
    }


    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public ModelAndView insertUser(@RequestParam(value = "customerName") String customerName,
                                   HttpSession session) throws SQLException {

        if (session.getAttribute("user") != null) {

            Customer customer = new Customer(customerName);
            customerService.insertCustomer(customer);

            return new ModelAndView("redirect:" + "/customer");
        } else {
            return new ModelAndView("redirect:" + "/login");
        }
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteCustomer(@PathVariable("id") String id,HttpSession session) throws SQLException {
        if (session.getAttribute("user") != null) {
            customerService.deleteCustomer(Integer.parseInt(id));
            return new ModelAndView("redirect:" + "/customer");
        } else {
            return new ModelAndView("redirect:" + "/login");
        }
    }

    @RequestMapping(value = "/modify/{id}", method = RequestMethod.GET)
    public ModelAndView getOneCustomer(@PathVariable("id") String id, HttpSession session) throws SQLException {

        if (session.getAttribute("user") != null) {
            return new ModelAndView("modifyCustomer", "customer",customerService.getOneCustomer(Integer.parseInt(id)));
        } else {
            return new ModelAndView("redirect:" + "/login");
        }
    }

    @RequestMapping(value = "/modify/{id}", method = RequestMethod.POST)
    public ModelAndView updateOneCustomer(@PathVariable("id") String id,
                                          @RequestParam(value = "customerName") String customerName,
                                          HttpSession session) {


        if (session.getAttribute("user") != null) {

            Customer customer = new Customer();
            customer.setId(Integer.parseInt(id));
            customer.setCustomerName(customerName);
            customerService.UpdateOneCustomer(customer);

            return new ModelAndView("redirect:" + "/customer");
        } else {
            return new ModelAndView("redirect:" + "/login");
        }
    }

}
