package com.tw.core.Dao;

import com.tw.core.entity.Employee;
import com.tw.core.entity.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class UserDaoTest {

    @BeforeClass
    public static void setProperty(){
        System.setProperty("jdbc.active.file","test");
    }

    @Autowired
    private UserDao userDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void testGetUsers() throws Exception {
        List<User> userList = userDao.getUsers();
        assertEquals(userList.size(),5);
    }

    @Test
    public void testInsertUsers() throws Exception {
        Employee employee = new Employee("lyj","male",29,"233@qq.com","coach","TRUE");
        employeeDao.insertEmployee(employee);
        User user = new User("ad","123",employee);
        userDao.insertUsers(user);

        List<User> userList = userDao.getUsers();
        assertEquals(userList.size(),6);
    }

    @Test
    public void testDeleteUsers() throws Exception {
        userDao.deleteUsers(1);
        List<User> userList = userDao.getUsers();
        assertEquals(userList.size(),4);
    }

    @Test
    public void testGetOneUser() throws Exception {
        User user = userDao.getOneUser(2);

        assertNotEquals(user,null);
        assertEquals(user.getName(),"admin2");
    }

    @Test
    public void testUpdateOneUser() throws Exception {
        Employee employee = employeeDao.getOneEmployee(1);
        User user = new User("adddd","123",employee);
        user.setId(1);
        userDao.UpdateOneUser(user);

        user = userDao.getOneUser(1);
        assertEquals(user.getName(),"adddd");
    }
}