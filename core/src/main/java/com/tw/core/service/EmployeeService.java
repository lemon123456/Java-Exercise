package com.tw.core.service;

import com.tw.core.Dao.EmployeeDao;
import com.tw.core.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> getEmployees(){
        try {
            return employeeDao.getEmployees();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertEmployee(Employee employee){
        try {
            employeeDao.insertEmployee(employee);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Employee getOneEmployee(int id){
        try{
            return employeeDao.getOneEmployee(id);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void UpdateOneEmployee(Employee employee){
        try{
            employeeDao.UpdateOneEmployee(employee);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
//
//    public static void main(String arg[]) throws SQLException{
//        EmployeeService employeeService = new EmployeeService();
//        System.out.println(employeeService.getEmployees());
//
//    }
}
