package com.book_app.book_app.services;

import java.util.List;

import com.book_app.book_app.dao.BookRepo;
import com.book_app.book_app.entities.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class BookService {

    @Autowired
    private BookRepo bookRepo;


    public List<Book> getBooks(){

        List<Book> lst = (List<Book>)bookRepo.findAll();
        
        return lst;

    }
    public Book getBookById(int id){

        Book bk = bookRepo.findById(id);
        
        return bk;

    }

    public Book addBook(Book book){

        Book b =  bookRepo.save(book);
        return b;
    }


    public void deleteBook(int id){
        bookRepo.deleteById(id);
    }


    public Book updateBook(Book book,int id){



        book.setId(id);
        Book bk = bookRepo.save(book);
        return bk;
    }
    
}
