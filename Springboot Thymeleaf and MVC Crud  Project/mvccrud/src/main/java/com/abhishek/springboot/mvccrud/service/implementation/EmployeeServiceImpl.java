package com.abhishek.springboot.mvccrud.service.implementation;

import com.abhishek.springboot.mvccrud.dao.EmployeeRepository;
import com.abhishek.springboot.mvccrud.model.Employee;
import com.abhishek.springboot.mvccrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
       this.employeeRepository = theEmployeeRepository;
    }

    @Override
    public List<Employee> findAll() {

        return this.employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> employee =  this.employeeRepository.findById(id);

        Employee theEmployee = null;
        if (employee.isPresent()){
            theEmployee = employee.get();
        }else {
            throw  new RuntimeException("Employee with id: "+id+" is not present!");
        }
        return theEmployee;
    }

    @Override
    public String save(Employee employee) {
         this.employeeRepository.save(employee);
         return "Employee with id: "+employee.getId()+" saved successfully!";
    }

    @Override
    public Employee update(Employee employee,int id) {
        Optional<Employee>existingEmployee = this.employeeRepository.findById(id);

        if (existingEmployee.isPresent()){

            existingEmployee.get().setFirstName(employee.getFirstName());
            existingEmployee.get().setLastName(employee.getLastName());
            existingEmployee.get().setEmail(employee.getEmail());
            Employee updatedEmployee = existingEmployee.get();
            this.employeeRepository.save(updatedEmployee);
            return updatedEmployee;
        }else {
            return existingEmployee.get();
        }
    }

    @Override
    public String deleteById(int id) {
        Optional<Employee>existingEmployee = this.employeeRepository.findById(id);
        if (existingEmployee.isPresent()){
            this.employeeRepository.deleteById(id);
            return "Employee with id: "+existingEmployee.get().getId()+" deleted successfully!";
        }else {
            return "Employee with id: "+id+ " does not exist";
        }

    }
}
