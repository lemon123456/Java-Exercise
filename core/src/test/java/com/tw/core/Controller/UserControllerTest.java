package com.tw.core.Controller;

import com.tw.core.controller.UserController;
import com.tw.core.entity.Employee;
import com.tw.core.entity.User;
import com.tw.core.service.EmployeeService;
import com.tw.core.service.PasswordEncryption;
import com.tw.core.service.UserService;
import org.hibernate.service.spi.InjectService;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.mockito.Mockito.*;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:applicationContext.xml"})
public class UserControllerTest {

    @BeforeClass
    public static void setProperty() {
        System.setProperty("jdbc.active.file", "test");
    }

    @Mock
    private UserService userService;

    @Mock
    private EmployeeService employeeService;

    @Mock
    private PasswordEncryption passwordEncryption;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }


    @Test
    public void testGetUsers() throws Exception {
        List<User> users = new ArrayList<User>();
        users.add(new User("Lily", "123456", new Employee("Lily","male",12,"34@dd","coach","true")));
        users.add(new User("Ada", "123456", new Employee("Lily","male",12,"34@dd","coach","true")));

        when(userService.getUsers()).thenReturn(users);


        this.mockMvc.perform(get("/users")).andExpect(status().isOk());
        verify(userService, times(1)).getUsers();
    }

    @Test
    public void testAddUser() throws Exception {
        this.mockMvc.perform(post("/users")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("name", "liyujing")
                .param("password", "123")
                .param("employeeId", "5"))
        .andExpect(status().isOk());
    }

    @Test
    public void testDeleteUser() throws Exception {

    }

    @Test
    public void testUpdateOneUser() throws Exception {

    }
}