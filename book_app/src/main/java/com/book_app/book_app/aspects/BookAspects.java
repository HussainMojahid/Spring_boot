package com.book_app.book_app.aspects;

// import org.aspectj.lang.annotation.After;
// import org.aspectj.lang.annotation.AfterReturning;
// import org.aspectj.lang.annotation.AfterThrowing;
// import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
// import org.aspectj.lang.annotation.Before;
// import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Aspect
@Service //work same as Component
public class BookAspects {

    // @Before(value = "execution(* com.book_app.book_app.controllers.BookController.getBooks(..) )")
    // public void GetBooks(){
    //     System.out.println("getbooks Mapping Is Runnig");
    // }
    // @After(value = "execution(* com.book_app.book_app.controllers.BookController.*(..) )")
    // public void atGetBookById(){
    //     System.out.println("Any Mapping Is Runnig");
    // }
    // @Around(value = "execution(* com.book_app.book_app.controllers.BookController.*(..) )")
    // public void atGetBookById(){
    //     System.out.println("Any Mapping Is Runnig");
    // }
    // @AfterReturning(value = "execution(* com.book_app.book_app.controllers.BookController.*(..) )")
    // public void atGetBookById(){
    //     System.out.println("Any Mapping Is Runnig");
    // }
    // @AfterThrowing(value = "execution(* com.book_app.book_app.controllers.BookController.*(..) )")
    // public void atGetBookById(){
    //     System.out.println("Any Mapping Is Runnig");
    // }


    
}
