package com.abhishek.restcrudapi.dao.implementation;

import com.abhishek.restcrudapi.dao.EmployeeDAO;
import com.abhishek.restcrudapi.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {

        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
        List<Employee> employees = theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int Id) {
        Employee foundEmployee = entityManager.find(Employee.class, Id);
        if (foundEmployee == null){
            throw new RuntimeException("Employee with id " +Id+ " not found");
        }
        return foundEmployee;
    }

    @Override
    public Employee save(Employee emp) {
        entityManager.persist(emp);
        return emp;
    }

    @Override
    public Employee update(int Id, Employee emp) {
        Employee existingEmployee = entityManager.find(Employee.class, Id);
        existingEmployee.setFirstName(emp.getFirstName());
//        entityManager.flush();
        existingEmployee.setLastName(emp.getLastName());
        existingEmployee.setEmail(emp.getEmail());
        //Employee updatedEmployee = entityManager.merge(existingEmployee);
        return existingEmployee;
    }

    @Override
    public String delete(int Id) {
        Employee employee = entityManager.find(Employee.class, Id);
        entityManager.remove(employee);
        return "Employee with id " + employee.getId() + " deleted successfully!";

    }
}
