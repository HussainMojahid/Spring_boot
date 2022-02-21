package com.spring_rest_api_pro1.spring_rest_api_pro1.repo;

import java.util.List;

import com.spring_rest_api_pro1.spring_rest_api_pro1.entities.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User,Integer> {


    public User findById(int id);
    public User findByIdAndStatus(int id, boolean b);

    public List<User> findByStatus(boolean status);

    public List<User> findBylastNameContaining(String str);

    public List<User> findBylastNameContainingAndStatus(String str,boolean b);


    
}
