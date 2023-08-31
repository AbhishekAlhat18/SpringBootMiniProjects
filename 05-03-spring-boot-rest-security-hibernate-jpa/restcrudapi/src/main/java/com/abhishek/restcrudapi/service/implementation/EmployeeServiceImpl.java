package com.abhishek.restcrudapi.service.implementation;

import com.abhishek.restcrudapi.dao.EmployeeRepository;
import com.abhishek.restcrudapi.entity.Employee;
import com.abhishek.restcrudapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<Employee> findAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee findById(int Id) {
        Optional<Employee> existingEmployee = employeeRepository.findById(Id);

        Employee employee = null;
        if (existingEmployee.isPresent()) {
            employee = existingEmployee.get();

        }
        return employee;


    }

    @Override
    public Employee save(Employee emp) {
        return employeeRepository.save(emp);
    }

    @Override
    public Optional<Employee> update(int Id, Employee emp) {
        Optional<Employee> employee = employeeRepository.findById(Id);
        if (employee.isPresent()) {
            Employee existingemployee = employee.get();
            existingemployee.setFirstName(emp.getFirstName());
            existingemployee.setLastName(emp.getLastName());
            existingemployee.setEmail(emp.getEmail());


            employeeRepository.save(existingemployee);
            return employee;
        }

        return employee;
    }

    @Override
    public String delete(int Id) {
        boolean employee = employeeRepository.findById(Id).isPresent();
        if (employee) {
            employeeRepository.deleteById(Id);
            return "Employee with id: " + Id + " deleted successfully";
        } else {
            return "Employee with id: " + Id + " does not exist";
        }

    }
}
