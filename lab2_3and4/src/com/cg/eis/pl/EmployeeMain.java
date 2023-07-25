package com.cg.eis.pl;

import java.util.Scanner;
import com.cg.eis.bean.Employee;
import com.cg.eis.exception.EmployeeException;
import com.cg.eis.service.EmployeeService;
import com.cg.eis.service.EmployeeServiceImpl;

public class EmployeeMain {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        EmployeeService employeeService = new EmployeeServiceImpl();

        System.out.println("Enter Employee Details:");
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // Consume the new line character left by nextInt()

        System.out.print("Name: ");
        String name = sc.nextLine();
        
        try {
        	System.out.print("Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine(); // Consume the new line character left by nextDouble()
            throw new EmployeeException();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
        System.out.print("Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine(); // Consume the new line character left by nextDouble()

        System.out.print("Designation: ");
        String designation = sc.nextLine();

        Employee employee = new Employee(id, name, salary, designation);
        employeeService.getEmployeeDetails(employee);

        System.out.println("\nInsurance Scheme Details:");
        employeeService.displayEmployeeDetails(employee);

        sc.close();
    }
}

