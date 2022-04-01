package com.spring_rest_api_pro1.spring_rest_api_pro1.repo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.spring_rest_api_pro1.spring_rest_api_pro1.entities.User;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepoTest {

    @Autowired
    UserRepo userRepo;


    @Test
    void testFindById() {
        User user = new User(1, "xyz", "xyz", 94305, "Darbhanga", "Developer", 1, true);
        
        userRepo.save(user);
        
        Iterable<User> user1 = userRepo.findAll();
        Assertions.assertThat(user1).extracting(User::getFirstName).contains("xyz");
        assertNotNull(user.getId());
        int id = user.getId();
        userRepo.delete(user);
        Assertions.assertThat(userRepo.findById(id)).isNull();
    }

    @Test
    void testFindByIdAndStatus() {

    }

    @Test
    void testFindByStatus() {

    }

    @Test
    void testFindBylastNameContaining() {

    }

    @Test
    void testFindBylastNameContainingAndStatus() {

    }
}
