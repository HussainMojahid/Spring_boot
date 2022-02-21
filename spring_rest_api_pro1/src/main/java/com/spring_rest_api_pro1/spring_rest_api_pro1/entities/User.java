package com.spring_rest_api_pro1.spring_rest_api_pro1.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private int contact;

    private String address;

    private String job;

    private int role;

    private boolean status;

    

    public User() {

        super();
    }



    public User(int id, String firstName, String lastName, int contact, String address, String job, int role,
            boolean status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.address = address;
        this.job = job;
        this.role = role;
        this.status = status;
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }



    public String getFirstName() {
        return firstName;
    }



    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }



    public String getLastName() {
        return lastName;
    }



    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public int getContact() {
        return contact;
    }



    public void setContact(int contact) {
        this.contact = contact;
    }



    public String getAddress() {
        return address;
    }



    public void setAddress(String address) {
        this.address = address;
    }



    public String getJob() {
        return job;
    }



    public void setJob(String job) {
        this.job = job;
    }



    public int getRole() {
        return role;
    }



    public void setRole(int role) {
        this.role = role;
    }



    public boolean isStatus() {
        return status;
    }



    public void setStatus(boolean status) {
        this.status = status;
    }



    @Override
    public String toString() {
        return "User [address=" + address + ", contact=" + contact + ", firstName=" + firstName + ", id=" + id
                + ", job=" + job + ", lastName=" + lastName + ", role=" + role + ", status=" + status + "]";
    }

    


    


    





    
}
