package com.ntt.employeespringboot2.dao;

import com.ntt.employeespringboot2.models.Employees;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface EmployeesRepository extends MongoRepository<Employees, String> {

    Page<Employees> findAll(Pageable pageable);
    Optional<Employees> findEmployeesByEmail(String email);

}
