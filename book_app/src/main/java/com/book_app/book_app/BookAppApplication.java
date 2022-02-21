package com.book_app.book_app;

// import com.book_app.book_app.aspects.BookAspects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class BookAppApplication {

	public static void main(String[] args) {
	 	// ConfigurableApplicationContext context = 
		 SpringApplication.run(BookAppApplication.class, args);
		// BookAspects ba = context.getBean(BookAspects.class);
		// ba.atGetBookById();
	}

}
