package com.example.RestService;

import org.springframework.stereotype.Repository;

// importing the employees class to use the defined properties in this class
import com.example.RestService.Employees;
import java.util.List;

@Repository

//class to create list of employees 
public class EmployeeManager {
    private static Employees list = new Employees();

    //this static block is executed before executing the main block 
    static
    {
        // creating a few employees and adding them to the list 
        list.getEmployeeList().add(
            new Employee(1, 
            "Prem", 
            "Tiwari", 
            "chapdradreams@gmail.com", 
            "software engineer"));

        list.getEmployeeList().add(
            new Employee(2, 
            "Vikash", 
            "Kumar", 
            "abc@gmail.com", 
            "DevOps engineer"));

        list.getEmployeeList().add(
            new Employee(3, 
            "Ritesh", 
            "Ojha", 
            "asdjf@gmail.com", 
            "backend engineer"));
    }

    //method to return the list 
    public Employees getAllEmployees()
    {
        return list;
    }

    //method to add an employee to the employees list 
    public void addEmployee(Employee employee)
    {
        list.getEmployeeList().add(employee);
    }
}
