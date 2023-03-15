package com.ntt.employeespringboot2.services;
import com.ntt.employeespringboot2.exceptions.EmptyInputException;
import com.ntt.employeespringboot2.exceptions.IllegalArgumentExceptionCustom;
import com.ntt.employeespringboot2.dao.EmployeesRepository;
import com.ntt.employeespringboot2.exceptions.RecordNotFoundException;
import com.ntt.employeespringboot2.models.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployeesService {

    @Autowired
    EmployeesRepository employeesRepository;

    public Page<Employees> getAllEmployees(Pageable pageable) {
        return employeesRepository.findAll(pageable);
    }

    public List<Employees> getAllEmployees() throws IllegalArgumentExceptionCustom {
        List<Employees> employees = employeesRepository.findAll();
        if (employees.isEmpty()){
            throw new IllegalArgumentExceptionCustom("Oops cannot get all employees");

        }
        return  employees;
    }
    public Employees getEmployeeById(String id) throws RecordNotFoundException {
        return employeesRepository.findById(id).orElseThrow(() -> new RecordNotFoundException("Employee not found!"));
    }

    public Employees createEmployee(Employees employee) {
        if (employee.getName().isEmpty() || employee.getName().length() == 0 || employee.getName().equals("") || employee.getName().isBlank()){
            throw new EmptyInputException("Input Fields are empty");

        }
        Employees saveEmployee = employeesRepository.save(employee);
        return saveEmployee;
    }

    public Employees updateEmployee(String id, Employees requestEmployee) throws RecordNotFoundException {
        return employeesRepository.findById(id).map(employee -> {
            employee.setName(requestEmployee.getName());
            employee.setLevel(requestEmployee.getLevel());
            employee.setStatus(requestEmployee.getStatus());
            return employeesRepository.save(employee);
        }).orElseThrow(() -> new RecordNotFoundException("Employee not found!"));
    }

    public String deleteEmployee(String id) throws RecordNotFoundException {
        return employeesRepository.findById(id).map(employee -> {
            employeesRepository.delete(employee);
            return String.format("%s has been deleted!", employee.getName());
        }).orElseThrow(() -> new RecordNotFoundException("Employee not found!"));
    }
}
