package com.company.employee_management.controler;


import com.company.employee_management.entity.Employee;
import com.company.employee_management.repository.EmployeeRepository;
import com.company.employee_management.service.EmployeeService;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import static com.company.employee_management.utils.ResponseConstants.*;
@RequestMapping(path = "/api/v1/employee")
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;


    public ResponseEntity<Response> employee(
            @RequestHeader(value = AUTHORIZATION)
            @Parameter(description = "Oath bearer token will be sent", required = true)
            @NotBlank
            @Size(max = 500) final String authorization,

            @RequestHeader(value = TRACE_ID)
            @NotBlank
            @Size(max = 500) final String traceId,


            @RequestHeader(value = CHANNEL_TYPE)
            @NotBlank
            @Size(max = 500) final String channelType,

            @RequestHeader(value = SESSION_ID)
            @NotBlank
            @Size(max = 500) final String sessionId

    )
    {
        return (ResponseEntity<Response>) ResponseEntity.ok();
    }



    @GetMapping (path = "/findWorkers")
//    public String status (){
//        return "Service is up and Running";
//    }
    List<Employee>getEmployee(){
return employeeRepository.findAll();
    }


    @PostMapping(path = "/newRegistration")
    public void registerNewEmployee(@RequestBody Employee employee){
        System.out.println(employee);
        employeeService.addNewEmployee(employee);
    }


    @PutMapping("/update/{id}")  //for change or updating data
    public void updateEmployee(
            @PathVariable("id") Long id,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String email) {
        employeeService.updateEmployee(id, firstName, lastName, email);
    }


    @DeleteMapping ("delete/{id}")   //for deleting data
    public void deleteEmployee(@PathVariable("id") Long id){
        employeeService.deleteStudent(id);
    }
}


