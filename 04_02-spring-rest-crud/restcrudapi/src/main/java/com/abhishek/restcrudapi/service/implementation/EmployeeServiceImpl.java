package com.abhishek.restcrudapi.service.implementation;

import com.abhishek.restcrudapi.dao.EmployeeDAO;
import com.abhishek.restcrudapi.entity.Employee;
import com.abhishek.restcrudapi.service.EmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return this.employeeDAO.findAll();
    }

    @Override
    public Employee findById(int Id) {
        return employeeDAO.findById(Id);
    }

    @Override
    @Transactional
    public Employee save(Employee emp) {
        return employeeDAO.save(emp);
    }

    @Override
    @Transactional
    public Employee update(int Id, Employee emp) {
        return employeeDAO.update(Id, emp);
    }

    @Override
    @Transactional
    public String delete(int Id) {
        return employeeDAO.delete(Id);
    }
}
