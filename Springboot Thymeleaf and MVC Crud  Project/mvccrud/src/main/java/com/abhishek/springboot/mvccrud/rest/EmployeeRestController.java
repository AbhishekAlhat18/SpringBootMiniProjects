//package com.abhishek.springboot.mvccrud.rest;
//
//
//import com.abhishek.springboot.mvccrud.model.Employee;
//import com.abhishek.springboot.mvccrud.service.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping(path = "/api")
//public class EmployeeRestController {
//
//    private EmployeeService employeeService;
//
//    @Autowired
//    public EmployeeRestController(EmployeeService theEmployeeService) {
//        this.employeeService = theEmployeeService;
//    }
//
//    @GetMapping(path = "/employees")
//    public List<Employee> findAll() {
//        return this.employeeService.findAll();
//    }
//
//    @GetMapping(path = "/employees/{employeeId}")
//    public Employee findById(@PathVariable int employeeId) {
//        return this.employeeService.findById(employeeId);
//    }
//
//    @PostMapping(path = "/employees")
//    public String save(@RequestBody Employee employee) {
//        return this.employeeService.save(employee);
//    }
//
//    @PutMapping(path = "/employees/{employeeId}")
//    public Employee update(@RequestBody Employee employee, @PathVariable int employeeId) {
//        return this.employeeService.update(employee, employeeId);
//    }
//
//    @DeleteMapping(path = "/employees/{employeeId}")
//    public String deleteById(@PathVariable int employeeId){
//        return this.employeeService.deleteById(employeeId);
//    }
//
//
//
//    @ExceptionHandler
//    private String exceptions(Exception exc) {
//        return exc.getMessage();
//    }
//
//
//}
