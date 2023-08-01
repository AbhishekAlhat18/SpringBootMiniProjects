package com.abhishek.restcrudapi.controller;


import com.abhishek.restcrudapi.entity.Employee;
import com.abhishek.restcrudapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/employees")
    private List<Employee> getAllEmployees() {
        return this.employeeService.findAll();
    }

    @GetMapping(path = "/employees/{employeeId}")
    private Employee getById(@PathVariable("employeeId") int Id) {

        return this.employeeService.findById(Id);
    }

    @PostMapping(path = "/employees")
    private Employee addEmployee(@RequestBody Employee emp) {
        return this.employeeService.save(emp);
    }

//    @PutMapping (path = "/employees")
//    private Employee updateEmployee(@RequestBody Employee emp) {
//        return this.employeeService.save(emp);
//    }

    @PutMapping(path = "/employees/{employeeId}")
    private Optional<Employee> updateEmployee(@PathVariable("employeeId") int Id, @RequestBody Employee emp) {
        return this.employeeService.update(Id, emp);

    }

    @DeleteMapping(path = "/employees/{Id}")
    private String deleteEmployee(@PathVariable int Id) {
        return this.employeeService.delete(Id);
    }

//    @ExceptionHandler
//    private String EmployeeNotException(Exception exc){
//        return exc.getMessage();
//    }


}
