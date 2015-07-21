package com.tw.core.service;

import com.tw.core.Dao.CustomerDao;
import com.tw.core.Dao.EmployeeDao;
import com.tw.core.entity.Customer;
import com.tw.core.entity.Employee;
import com.tw.core.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by twer on 7/21/15.
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public List<Customer> getCustomers(){
        try {
            return customerDao.getCustomers();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void insertCustomer(Customer customer){
        try {
            customerDao.insertCustomer(customer);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomer(int id){
        try {
            customerDao.deleteCustomer(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer getOneCustomer(int id){
        try{
            return customerDao.getOneCustomer(id);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void UpdateOneCustomer(Customer customer){
        try{
            customerDao.UpdateOneCustomer(customer);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

        public static void main(String arg[]) throws SQLException{
            System.out.println("@@@@@@@@@@@@@@@@@");
            CustomerService customerService = new CustomerService();
            System.out.println("#################");
            System.out.println(customerService.getCustomers());
            System.out.println("$$$$$$$$$$$$$$$$");

    }
}
