package com.spring_rest_api_pro1.spring_rest_api_pro1.services;

import java.util.List;

import com.spring_rest_api_pro1.spring_rest_api_pro1.entities.User;
import com.spring_rest_api_pro1.spring_rest_api_pro1.repo.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserService {


    @Autowired
    UserRepo userRepo;

    public User addUser(User user){

        User u = userRepo.save(user);

        return u;
    }


    // public List<User> getBooleanUser(boolean b){

    //     List<User> lst =  (List<User>)userRepo.findByStatus(b);


    //     return lst; 
    // }

    public List<User> getAllUser(){

        List<User> lst =  (List<User>)userRepo.findAll();


        return lst; 
    }
    public User  getUser(int id){

        User user =  userRepo.findByIdAndStatus(id,true);
        return user; 
    }


    // public List<User> getContaining(String str){

    //     List<User> lst = userRepo.findBylastNameContaining(str);

    //     return lst;

    // }


    public List<User> getOnConditions(String str,boolean b){

        List<User> lst = userRepo.findBylastNameContainingAndStatus(str, b);
        System.out.println(lst );
        for (User user : lst) {
            System.out.println(user);
        }
        return lst;

    }


    public User updateUser(User u,int id){
        u.setId(id);
        User user =  userRepo.save(u);

        return user;


    }


    public void deleteUser(int id) {

       User user =  userRepo.findById(id);
       user.setStatus(false);
       userRepo.save(user);
        
    }



    
}
