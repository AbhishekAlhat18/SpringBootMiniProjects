package com.abhishek.springboot.mvccrud.controller;


import com.abhishek.springboot.mvccrud.model.Employee;
import com.abhishek.springboot.mvccrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService theEmployeeService) {
        this.employeeService = theEmployeeService;
    }

    @GetMapping(path = "/employees")
    public String findAll(Model theModal) {
        List<Employee> theEmployees = this.employeeService.findAll();

        theModal.addAttribute("employees", theEmployees);

        return "employees/list-employees";


    }

    @GetMapping(path = "/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Employee employee = new Employee();

        theModel.addAttribute("employee", employee);

        return "employees/employee-form";

    }

    @PostMapping(path = "/processEmployeeForm")
    public String processEmployeeForm(Model theModal, @ModelAttribute(value = "employee") Employee theEmployee) {
//        Employee newEmployee = new Employee();
//        newEmployee.setFirstName(theEmployee.getFirstName());
//        newEmployee.setLastName(theEmployee.getLastName());
//        newEmployee.setEmail(theEmployee.getEmail());
        System.out.println("Before this.employeeService.save(theEmployee) id is: " + theEmployee.getId());

        this.employeeService.save(theEmployee);

        System.out.println("After this.employeeService.save(theEmployee) id is: " + theEmployee.getId());

//        List<Employee> theEmployees = this.employeeService.findAll();
//
//        theModal.addAttribute("employees",theEmployees);

//        return "employees/employee-confirmation-page";

        return "redirect:/api/employees";

    }

    @GetMapping(path = "/showEmployeeUpdateForm")
    public String showEmployeeUpdateForm(@RequestParam(value = "employeeId") int id, Model theModel) {
        Employee existingEmployee = this.employeeService.findById(id);
        theModel.addAttribute("employee", existingEmployee);

        return "employees/employee-update-form";
    }

    @GetMapping(path="/deleteEmployee/{employeeId}")
    public String deleteEmployee(@PathVariable(value = "employeeId") int id) {
        System.out.println("employeeId: " +id);
        this.employeeService.deleteById(id);
        return"redirect:/api/employees";

    }


}
