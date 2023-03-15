package com.ntt.employeespringboot3.controllers;


import com.ntt.employeespringboot3.exceptions.IllegalArgumentExceptionCustom;
import com.ntt.employeespringboot3.exceptions.RecordNotFoundException;
import com.ntt.employeespringboot3.models.Employees;
import com.ntt.employeespringboot3.services.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    @Autowired
    EmployeesService employeesService;

   /* @GetMapping
    public ResponseEntity<Page<Employees>> getAllEmployees(@ApiIgnore Pageable pageable) throws RecordNotFoundException {
        return new ResponseEntity<>(employeesService.getAllEmployees(pageable), new HttpHeaders(), HttpStatus.OK);
    }*/
    @GetMapping
    public ResponseEntity<List<Employees>> getAllEmployees() throws IllegalArgumentExceptionCustom {
        return new ResponseEntity<>(employeesService.getAllEmployees(), new HttpHeaders(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Employees> getEmployeeById(@PathVariable String id) throws RecordNotFoundException {
        return new ResponseEntity<>(employeesService.getEmployeeById(id), new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employees> createEmployee(@RequestBody Employees requestEmployee) {
        return new ResponseEntity<>(employeesService.createEmployee(requestEmployee), new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employees> updateEmployee(@PathVariable String id, @RequestBody Employees requestEmployee) throws RecordNotFoundException {
        return new ResponseEntity<>(employeesService.updateEmployee(id, requestEmployee), new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String id) throws RecordNotFoundException {
        return new ResponseEntity<>(employeesService.deleteEmployee(id), new HttpHeaders(), HttpStatus.OK);
    }

}
