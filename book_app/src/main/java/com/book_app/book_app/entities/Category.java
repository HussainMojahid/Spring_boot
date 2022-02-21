package com.book_app.book_app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "book_type")
    private String type;
    @Column(name ="book_desc")
    private String desc;
    public Category() {
        super();
    }
    public Category(String type, String desc) {
        this.type = type;
        this.desc = desc;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    @Override
    public String toString() {
        return "Category [desc=" + desc + ", type=" + type + "]";
    }

    
    

    

    



}
