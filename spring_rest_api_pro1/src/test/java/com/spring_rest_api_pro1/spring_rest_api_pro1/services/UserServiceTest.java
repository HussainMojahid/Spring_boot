package com.spring_rest_api_pro1.spring_rest_api_pro1.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.spring_rest_api_pro1.spring_rest_api_pro1.entities.User;
import com.spring_rest_api_pro1.spring_rest_api_pro1.repo.UserRepo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;




@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserServiceTest {


    @Mock
    UserRepo userRepo;

    @InjectMocks
    UserService userService;


    @Test
    void testAddUser() {

        User user = User.builder()
                        .id(1)
                        .firstName("Mojahid")
                        .lastName("Hussain")
                        .address("Darbhanga")
                        .contact(94305L)
                        .job("Dev")
                        .status(false)
                        .role(1)
                        .build();
        User user1 = User.builder()
                        .id(2)
                        .firstName("Mohammad")
                        .lastName("Hussain")
                        .address("Darbhanga")
                        .contact(94305L)
                        .job("Dev")
                        .status(true)
                        .role(1)
                        .build();
        User user2 = User.builder()
                        .id(3)
                        .firstName("Muzammil")
                        .lastName("Hussain")
                        .address("Darbhanga")
                        .contact(94305L)
                        .job("Dev")
                        .status(true)
                        .role(1)
                        .build();
        
        List<User> lst = new ArrayList<>(); 
        lst.add(user);
        lst.add(user1);
        lst.add(user2);
        when(userRepo.findAll()).thenReturn(lst);
        List<User> lst1 = userService.getAllUser();
        
        assertEquals(3, lst1.size());
        verify(userRepo).findAll();


    }

    @Test
    void testDeleteUser() {
        User user = User.builder()
                        .id(1)
                        .firstName("Mojahid")
                        .lastName("Hussain")
                        .address("Darbhanga")
                        .contact(94305L)
                        .job("Dev")
                        .status(true)
                        .role(1)
                        .build();


        when(userRepo.findById(1)).thenReturn(user);

        
        // Mockito.when(userService.d)

    


        userService.deleteUser(1);

        

        Assertions.assertThat(!user.isStatus());
        

    }

    @Test
    void testGetAllUser() {
        User user = User.builder()
                        .id(1)
                        .firstName("Mojahid")
                        .lastName("Hussain")
                        .address("Darbhanga")
                        .contact(94305L)
                        .job("Dev")
                        .status(false)
                        .role(1)
                        .build();
        User user1 = User.builder()
                        .id(2)
                        .firstName("Mohammad")
                        .lastName("Hussain")
                        .address("Darbhanga")
                        .contact(94305L)
                        .job("Dev")
                        .status(true)
                        .role(1)
                        .build();
        User user2 = User.builder()
                        .id(3)
                        .firstName("Muzammil")
                        .lastName("Hussain")
                        .address("Darbhanga")
                        .contact(94305L)
                        .job("Dev")
                        .status(true)
                        .role(1)
                        .build();

        List<User> lst = new ArrayList<>();
        lst.add(user);
        lst.add(user1);
        lst.add(user2);

        when(userRepo.findAll()).thenReturn(lst);

        userService.getAllUser();

        verify(userRepo).findAll();


    }

    // @Test
    // void testGetOnConditions() {

    // }

    @Test
    void testGetUser() {

        User user = User.builder()
                        .id(1)
                        .firstName("Mojahid")
                        .lastName("Hussain")
                        .address("Darbhanga")
                        .contact(94305L)
                        .job("Dev")
                        .status(true)
                        .role(1)
                        .build();

        when(userRepo.findByIdAndStatus(user.getId(),user.isStatus())).thenReturn(user);
        User user2 = userService.getUser(1);
        assertEquals(user.getId()==1,user2.getId()==1);
        

    }

    // @Test
    // void testUpdateUser() {

    // }
}
