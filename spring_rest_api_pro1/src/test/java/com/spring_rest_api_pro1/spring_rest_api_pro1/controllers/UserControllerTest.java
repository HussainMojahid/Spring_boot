package com.spring_rest_api_pro1.spring_rest_api_pro1.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring_rest_api_pro1.spring_rest_api_pro1.entities.User;
import com.spring_rest_api_pro1.spring_rest_api_pro1.services.UserService;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @MockBean
    UserService userService;

    @Autowired
    MockMvc mockMvc;


    @Test
    void testAddUser() throws Exception {

        User user = new User(1, "Mohammad", "Hussain", 94305, "Darbhanga", "Developer", 1, true);
        
        
        Mockito.when(userService.addUser(user)).thenReturn(user);

        var  request = MockMvcRequestBuilders.post("/user")
        .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user));

        mockMvc.perform(request).andExpect(status().isOk()).andExpect(jsonPath("$.firstName", Matchers.is("Mohammad")));
                            

       
    }

    public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

    

    @Test
    void testDeleteUser() throws Exception {

        mockMvc.perform(delete("/user/1")).andExpect(status().isOk()).andExpect(jsonPath("$", Matchers.hasToString("Entity Deleted")));

    }

    @Test
    void testGetActiveUser() throws Exception {

        User user = new User(1, "Mohammad", "Hussain", 94305, "Darbhanga", "Developer", 1, true);
        User user1 = new User(1, "Mojahid", "Hussain", 94305, "Darbhanga", "Developer", 1, true);
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user1);

        Mockito.when(userService.getAllUser()).thenReturn(list);

        mockMvc.perform(get("/user")).andExpect(status().isOk())    
                                    .andExpect(jsonPath("$[0].firstName",Matchers.is("Mohammad")))
                                    .andExpect(jsonPath("$[1].firstName", Matchers.is("Mojahid")));
                                
        
         

    }

    @Test
    void testGetUser() throws Exception {
        User user = new User(1, "Mohammad", "Hussain", 94305, "Darbhanga", "Developer", 1, true);

        // Mockito.when(userService.getUser(Mockito.anyInt())).thenReturn(user);

        BDDMockito.given(userService.getUser(Mockito.anyInt())).willReturn(user); //BDD Style

        mockMvc.perform(get("/user/1"))
                .andExpect(status().isOk())
                // .andExpect(jsonPath("$.firstName", Matchers.is("Mohammad")));
                .andExpect(jsonPath("$.firstName", Matchers.anything()));


    }

    @Test
    void testUpdateUser() throws Exception {
        User user = new User(1, "Mohammad", "Hussain", 94305, "Darbhanga", "Developer", 1, true);
        Mockito.when(userService.updateUser(user, 1)).thenReturn(user);
        var  request = MockMvcRequestBuilders.put("/user/{id}",1)
        .contentType(MediaType.APPLICATION_JSON).content(asJsonString(user));

        mockMvc.perform(request).andExpect(status().isOk()).andExpect(jsonPath("$.firstName", Matchers.is("Mohammad")));


    }
}
