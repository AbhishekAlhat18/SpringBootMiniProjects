package com.abhishek.springboot.mvccrud.service;

import com.abhishek.springboot.mvccrud.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<Employee>findAll();

    Employee findById(int id);

    String save(Employee employee);

    Employee update(Employee employee,int id);

    String deleteById(int id);
}
