package com.spring_rest_api_pro1.spring_rest_api_pro1;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.spring_rest_api_pro1.spring_rest_api_pro1.controllers.UserController;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class SpringRestApiPro1ApplicationTests {


	@Autowired
	UserController userController;


	


	

	@Test
	void contextLoads() {
		System.out.println(userController);

		// Assertions.assertThat(userController != notNull());
		assertNotEquals(null,userController);
	}

	

}
