package com.company.employee_management.service;

import com.company.employee_management.entity.Employee;
import com.company.employee_management.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;


@Slf4j
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public void addNewEmployee(Employee employee){
        Optional<Employee> findEmployee = repository.findEmployeeByEmail(employee.getEmail());
        if (findEmployee.isPresent()) {
            throw new IllegalStateException("You already registered this email");
        }
        log.info("Duplicate Email Address");
        repository.save(employee);
    }
//For Put Mapping
    @Transactional
    public void updateEmployee(Long id, String firstName, String lastName, String email) {
        Employee employee = repository.findById(id).orElseThrow(() -> new IllegalStateException(
                "employee with id" + id + "not exists"));
        if (firstName != null && firstName.length() > 0 && !Objects.equals(employee.getFirstName(), firstName)) {
            employee.setFirstName(firstName);
        }
        if (lastName != null && lastName.length() > 0 && !Objects.equals(employee.getLastName(), lastName)) {
            employee.setLastName(lastName);
        }
        if (email != null && email.length() > 0 && !Objects.equals(employee.getEmail(), email)) {
            employee.setEmail(email);
        }

    }
// For Delete Mapping
    public  void deleteStudent(Long id){
        boolean idExits = repository.existsById(id);
        if (!idExits){

           log.info("Employee id not present in DB");
        }
        repository.deleteById(id);
    }





}
