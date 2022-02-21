package com.book_app.book_app.services;

import java.util.List;

import com.book_app.book_app.dao.AuthorRepo;
import com.book_app.book_app.entities.Author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthorService{

    @Autowired
    private AuthorRepo authorRepo;


    public List<Author> getAllAuthor(){

        List<Author> lst = (List<Author>)authorRepo.findAll();
        return lst;

    }

}