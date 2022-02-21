package com.book_app.book_app.controllers;

import java.util.List;
import java.util.Optional;

import com.book_app.book_app.entities.Book;
import com.book_app.book_app.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping(path = "/books",produces = {"application/xml"})
    public ResponseEntity<List<Book>> getBooks(){
        List<Book> lst = this.bookService.getBooks();
        if(lst.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        System.out.println("Running xml Method");


        return ResponseEntity.status(HttpStatus.OK).body(lst);
    }
    @GetMapping(path = "/books",produces = {"application/json"})
    public ResponseEntity<List<Book>> getBooks1(){
        List<Book> lst = this.bookService.getBooks();
        if(lst.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        System.out.println("Running json Method");

        return ResponseEntity.status(HttpStatus.OK).body(lst);
    }



  

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBook1(@PathVariable("id") int id){
        Book bk = this.bookService.getBookById(id);
        if(bk==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(bk);
    }

    @PostMapping(path = "/books",consumes = {"application/xml"})
    public ResponseEntity<Book> addBook(@RequestBody Book book){

        Book b = null;
        try {
            b = this.bookService.addBook(book);
            return ResponseEntity.of(Optional.of(b));


            
        } catch (Exception e) {

            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable("id") int id){

        try {
            this.bookService.deleteBook(id);
            return ResponseEntity.ok("Deleted Succesfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PutMapping("/books/{id}")
    public ResponseEntity<Book> UpdateBook(@RequestBody Book bk,@PathVariable("id") int id){

        try {
            Book b=this.bookService.updateBook(bk, id);
            return ResponseEntity.of(Optional.of(b));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            
        }


    }





    
}
