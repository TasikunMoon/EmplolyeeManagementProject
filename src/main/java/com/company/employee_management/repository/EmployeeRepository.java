package com.company.employee_management.repository;

import com.company.employee_management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

   Optional<Employee>findEmployeeByEmail(String Email);
}
