package com.cg.eis.service;

import com.cg.eis.bean.Employee;

public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public void getEmployeeDetails(Employee employee) {
        // You can implement any additional logic for getting employee details here if needed.
        // For this example, we are not doing anything extra in this method.
    }

    @Override
    public void displayEmployeeDetails(Employee employee) {
        System.out.println("Employee Details:");
        System.out.println("-----------------");
        System.out.println("ID: " + employee.getId());
        System.out.println("Name: " + employee.getName());
        System.out.println("Salary: " + employee.getSalary());
        System.out.println("Designation: " + employee.getDesignation());
        System.out.println("Insurance Scheme: " + employee.getInsuranceScheme());
        System.out.println("-----------------");
    }
}



