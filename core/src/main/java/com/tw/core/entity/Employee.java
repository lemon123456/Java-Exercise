package com.tw.core.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.persistence.metamodel.ListAttribute;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by twer on 7/17/15.  name,role
 */

@Entity
@Table(name = "Employee")
public class Employee {
    private int id;
    private String name;
    private String role;

//    private Set<Customer> customers;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    public Employee(){

    }
//    public Employee(int id, String name, String role) {
//        this.id = id;
//        this.name = name;
//        this.role = role;
//    }


//    @OneToMany(mappedBy="")　
//    @LazyCollection(LazyCollectionOption.EXTRA)
//    Set<Customer> getCustomers()
//    {
//        return customers;
//    }
//
//    public void setCustomers(Set<Customer> customers)
//    {
//        this.customers = customers;
//    }
}
