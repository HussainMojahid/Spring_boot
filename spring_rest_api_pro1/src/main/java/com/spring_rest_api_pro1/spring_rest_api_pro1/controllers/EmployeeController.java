package com.spring_rest_api_pro1.spring_rest_api_pro1.controllers;

import java.util.List;

import com.spring_rest_api_pro1.spring_rest_api_pro1.entities.Employee;
import com.spring_rest_api_pro1.spring_rest_api_pro1.services.EmployeeService;

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
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/emp")
    public Employee addEmployee(@RequestBody Employee employee ){

        Employee emp = this.employeeService.addEmployee(employee);
        return emp;
    }

    @GetMapping("/emp")
    public List<Employee> getAllEmployee(@RequestParam(required =false) String Degination){

        if(Degination!=null){
            List<Employee> emp = this.employeeService.getEmployeeByDegination(Degination);
            return emp;

        }

        List<Employee> emp = this.employeeService.getAllEmployee();
        return emp;
    }

    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id") int id){

        Employee emp = this.employeeService.getEmployee(id);
        return emp;
    }

    @PutMapping("/emp/{id}")
    public ResponseEntity<Employee> updateUser(@RequestBody Employee employee,@PathVariable("id") int id){


        try {
            Employee u =this.employeeService.updateEmployee(employee,id);
            return ResponseEntity.ok().body(u);
            
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }

    }

    @DeleteMapping("/emp/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int id){

        try {
            this.employeeService.deleteEmployee(id);
            return ResponseEntity.ok().body("Entity Deleted");
            
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();

        }


    }
    
}
