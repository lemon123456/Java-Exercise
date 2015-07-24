package com.tw.core.entity;

import javax.persistence.*;

@Entity
@Table(name = "Customer")
public class Customer {

    private int id;
    private String customerName;

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

    public Customer() {
    }

    public Customer(int id, String customerName) {
        this.id = id;
        this.customerName = customerName;
    }

    public Customer(String customerName) {
        this.customerName = customerName;
    }
}
