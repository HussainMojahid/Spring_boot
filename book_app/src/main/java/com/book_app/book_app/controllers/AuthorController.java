package com.book_app.book_app.controllers;

import java.util.List;

import com.book_app.book_app.entities.Author;
import com.book_app.book_app.services.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;


    @GetMapping("/authors")
    public ResponseEntity<List<Author>> getAllAuthor(){

        List<Author> lst = this.authorService.getAllAuthor();
        if(lst.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.ok(lst);

    }
    
}
