package com.abhishek.restcrudapi.service;

import com.abhishek.restcrudapi.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int Id);

    Employee save(Employee emp);

    Employee update(int Id,Employee emp);

    String delete(int Id);
}
