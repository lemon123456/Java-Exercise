package com.tw.core.entity;

import javax.persistence.*;

/**
 * Created by twer on 7/17/15.
 */
@Entity
@Table(name = "Customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "id")
    private int id;
    @Column(name = "customerName")
    private String customerName;
    @Column(name = "coachId")
    private int coachId;

    public Customer() {
    }

    public Customer(int coachId, String customerName) {
        this.coachId = coachId;
        this.customerName = customerName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }
}
