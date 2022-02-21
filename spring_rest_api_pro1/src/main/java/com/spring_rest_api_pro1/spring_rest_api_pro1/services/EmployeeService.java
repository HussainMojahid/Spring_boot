package com.spring_rest_api_pro1.spring_rest_api_pro1.services;

import java.util.List;

import com.spring_rest_api_pro1.spring_rest_api_pro1.entities.Employee;
import com.spring_rest_api_pro1.spring_rest_api_pro1.repo.EmployeeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee addEmployee(Employee emp){

        Employee employee =  employeeRepo.save(emp);

        return employee;
    }


    
    public List<Employee> getAllEmployee(){

        List<Employee> lst = (List<Employee>)employeeRepo.findByUserStatus(true);
        
        return lst;

    }


    public Employee getEmployee(int id){
        Employee employee = employeeRepo.findByIdAndUserStatus(id,true);
        return employee;

    }



    public List<Employee> getEmployeeByDegination(String degination) {
        List<Employee> employee = employeeRepo.findByDeginationAndUserStatus(degination,true);
        return employee;
    }

    public Employee updateEmployee(Employee u,int id){
        u.setId(id);
        Employee employee =  employeeRepo.save(u);

        return employee;


    }

    public void deleteEmployee(int id) {

        Employee employee =  employeeRepo.findById(id);
        employee.getUser().setStatus(false);
        employeeRepo.save(employee);
         
     }
    
}
