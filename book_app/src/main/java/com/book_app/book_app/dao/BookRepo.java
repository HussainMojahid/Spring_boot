package com.book_app.book_app.dao;

import com.book_app.book_app.entities.Book;

import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<Book, Integer> {
    
    public Book findById(int id);
}
