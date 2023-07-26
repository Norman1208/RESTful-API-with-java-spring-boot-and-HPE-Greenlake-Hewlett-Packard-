package com.example.RestService;
import java.util.ArrayList;
import java.util.List;

// class to store the list of 
// all the employees in an 
// Array List 
public class Employees {
    private List<Employee> employeeList;

    //method to return the list 
    // of employees 
    public List<Employee> getEmployeeList()
    {
        if(employeeList == null) {
            employeeList=new ArrayList<>();
        }
        return employeeList;
    }

    public void setEmployeeList(
        List<Employee> employeeList)
    
    {
        this.employeeList = employeeList;
    }
}
