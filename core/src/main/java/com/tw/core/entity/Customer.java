package com.tw.core.entity;

import javax.persistence.*;

/**
 * Created by twer on 7/17/15.
 */
@Entity
@Table(name = "Customer")
public class Customer {

    private int id;
    private String customerName;
    private Employee employee;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "customerName")
    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="coachId")
    public Employee getEmployee() {return employee; }
    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }




    public Customer() {
    }
}
