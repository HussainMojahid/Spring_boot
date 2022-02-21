package com.book_app.book_app.dao;

import com.book_app.book_app.entities.Author;

// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<Author,Integer>{
    
}
