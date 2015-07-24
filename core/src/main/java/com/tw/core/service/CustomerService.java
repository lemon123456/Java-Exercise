package com.tw.core.service;

import com.tw.core.Dao.CustomerDao;
import com.tw.core.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

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

}
