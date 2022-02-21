package com.spring_rest_api_pro1.spring_rest_api_pro1.controllers;

import java.util.List;
import java.util.stream.Collectors;

import com.spring_rest_api_pro1.spring_rest_api_pro1.entities.User;
import com.spring_rest_api_pro1.spring_rest_api_pro1.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;



    @PostMapping("/user")
    public ResponseEntity<User> addUser(@RequestBody User user){


        try {
            User u =this.userService.addUser(user);
            return ResponseEntity.ok().body(u);
            
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

    }

    
    @GetMapping("/user")
    public ResponseEntity<List<User>> getActiveUser(@RequestParam(required = false) String lastName, @RequestParam(required = false) boolean all){

        System.out.println(lastName);

        if(lastName!=null && all==false){
            System.out.println("Condition 1");
            List<User> lst = this.userService.getOnConditions(lastName,true);

            if(lst.size()<=0){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                
            }
            return ResponseEntity.status(HttpStatus.OK).body(lst);

        }
        if(lastName!=null && all== true){
            System.out.println("Condition 2");
            List<User> lst1 = this.userService.getAllUser();
            List<User> lst = lst1.stream().filter(l->l.getLastName().contains(lastName)).collect(Collectors.toList());

            if(lst.size()<=0){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                
            }
            return ResponseEntity.status(HttpStatus.OK).body(lst);
        }

        if(all==true){
            System.out.println("Condition 3");
            List<User> lst = this.userService.getAllUser();
            if(lst.size()<=0){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
                
            }
            return ResponseEntity.status(HttpStatus.OK).body(lst);
        }
        
        System.out.println("Default Condition");
        // List<User> lst = this.userService.getBooleanUser(true);
        List<User> lst1 = this.userService.getAllUser();
        List<User> lst = lst1.stream().filter(l->l.isStatus()==true).collect(Collectors.toList()); 

        if(lst.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(lst);

    }

   
            
  


    @GetMapping("/user/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id){
        
        User user = this.userService.getUser(id);
        if(user==null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }


    @PutMapping("/user/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user,@PathVariable("id") int id){


        try {
            User u =this.userService.updateUser(user,id);
            return ResponseEntity.ok().body(u);
            
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id){

        try {
            this.userService.deleteUser(id);
            return ResponseEntity.ok().body("Entity Deleted");
            
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

    }
       
}
