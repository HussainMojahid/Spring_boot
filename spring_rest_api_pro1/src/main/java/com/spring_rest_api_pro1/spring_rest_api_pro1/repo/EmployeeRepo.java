package com.spring_rest_api_pro1.spring_rest_api_pro1.repo;

import java.util.List;

import com.spring_rest_api_pro1.spring_rest_api_pro1.entities.Employee;

import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepo extends CrudRepository<Employee,Integer> {

    public Employee findById(int id);
    public Employee findByIdAndUserStatus(int id,boolean b);

    public List<Employee> findByDeginationAndUserStatus(String degination,boolean b);

    public List<Employee> findByUserStatus(boolean b);
    
}
