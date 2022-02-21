package com.spring_rest_api_pro1.spring_rest_api_pro1.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Employee {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    private float salary;

    private String degination;

    public Employee() {

        super();
    }

    public Employee(int id, User user, float salary, String degination) {
        this.id = id;
        this.user = user;
        this.salary = salary;
        this.degination = degination;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getDegination() {
        return degination;
    }

    public void setDegination(String degination) {
        this.degination = degination;
    }

    @Override
    public String toString() {
        return "Employee [degination=" + degination + ", id=" + id + ", salary=" + salary + ", user=" + user + "]";
    }

    

    

    

    

    
}
