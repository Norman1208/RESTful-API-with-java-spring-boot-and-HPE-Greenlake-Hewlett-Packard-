package com.example.RestService;

import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

// import the above-fined classes to use the properties of those classes 
import com.example.RestService.Employees;
import com.example.RestService.EmployeeManager;
import com.example.RestService.Employee;

//creating the REST controller 
@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    
    @Autowired
    private EmployeeManager employeeManager;

    // implementing a GET method to get the list of all the employees 
    @GetMapping(
        path = "/",
        produces = "application/json"
    )

    public Employees getEmployees()
    {
        return employeeManager.getAllEmployees();
    }

    //create a POST method to add an employee to the list 
    @PostMapping(
        path = "/",
        consumes = "application/json",
        produces = "application/json")
    
    public ResponseEntity<Object> addEmployee(
        @RequestBody Employee employee)

    {
        //creating an ID of an employee from the number of employees 
        Integer id = employeeManager.getAllEmployees().getEmployeeList().size()+1;

        employee.setId(id);

        employeeManager.addEmployee(employee);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().
                        path("/{id}").buildAndExpand(employee.getId())
                        .toUri();

                    return ResponseEntity.created(location)
                            .build();
    }
}
