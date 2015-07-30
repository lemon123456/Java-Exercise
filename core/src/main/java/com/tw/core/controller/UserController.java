
package com.tw.core.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.tw.core.service.PasswordEncryption;
import com.tw.core.Util.HibernateProxyTypeAdapter;
import com.tw.core.entity.Employee;
import com.tw.core.entity.User;
import com.tw.core.service.EmployeeService;
import com.tw.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
@ResponseBody
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private PasswordEncryption passwordEncryption;

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
    public String getUsers(HttpServletResponse response) {

        List<User> userList = userService.getUsers();
        response.setContentType("text/html;charset=utf-8");
        return gson.toJson(userList);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addUser(@RequestParam(value = "name") String userName,
                          @RequestParam(value = "password") String userPassword,
                          @RequestParam(value = "employeeId") int employeeId) {

        Employee employee = employeeService.getOneEmployee(employeeId);
        User user = new User(userName, passwordEncryption.encodeByMD5(userPassword), employee);
        userService.insertUsers(user);
        return gson.toJson(user);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteUser(@RequestParam(value = "id") int id) {
        userService.deleteUsers(id);
    }


    @RequestMapping(method = RequestMethod.PUT)
    public void updateOneUser(@RequestParam(value = "id") int userId,
                              @RequestParam(value = "name") String userName,
                              @RequestParam(value = "password") String userPassword,
                              @RequestParam(value = "employeeId") int employeeId) {

        User user = new User(userId, userName, passwordEncryption.encodeByMD5(userPassword), employeeService.getOneEmployee(employeeId));
        userService.UpdateOneUser(user);
    }


}