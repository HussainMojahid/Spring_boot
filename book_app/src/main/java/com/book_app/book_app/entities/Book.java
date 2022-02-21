package com.book_app.book_app.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "book_title")
    private String title;

    @Column(name = "no_of_pages")
    private int page;

    @Column(name = "book_published_on")
    private Date publish_date;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Author author;
    @OneToOne(cascade = CascadeType.ALL)
    private Category category;


    public Book() {

        super();
    }


    public Book(int id, String name, String title, int page, Date publish_date, Author author, Category category) {
        this.id = id;
        this.title = title;
        this.page = page;
        this.publish_date = publish_date;
        this.author = author;
        this.category = category;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }



   


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public int getPage() {
        return page;
    }


    public void setPage(int page) {
        this.page = page;
    }


    public Date getPublish_date() {
        return publish_date;
    }


    public void setPublish_date(Date publish_date) {
        this.publish_date = publish_date;
    }


    public Author getAuthor() {
        return author;
    }


    public void setAuthor(Author author) {
        this.author = author;
    }


    public Category getCategory() {
        return category;
    }


    public void setCategory(Category category) {
        this.category = category;
    }


    @Override
    public String toString() {
        return "Book [author=" + author + ", category=" + category + ", id=" + id + ", page=" + page + ", publish_date="
                + publish_date + ", title=" + title + "]";
    }

    
    

    

    


    
}
