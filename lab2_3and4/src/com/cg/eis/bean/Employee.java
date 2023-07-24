package com.cg.eis.bean;

public class Employee {
    private int id;
    private String name;
    private double salary;
    private String designation;
    private String insuranceScheme;

    public Employee(int id, String name, double salary, String designation) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.designation = designation;
        this.insuranceScheme = findInsuranceScheme(salary, designation);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public String getDesignation() {
        return designation;
    }

    public String getInsuranceScheme() {
        return insuranceScheme;
    }

    private String findInsuranceScheme(double salary, String designation) {
        if (salary > 50000 && designation.equalsIgnoreCase("SE")) {
            return "Scheme A";
        } else if (salary >= 30000 && salary <= 50000 && designation.equalsIgnoreCase("Programmer")) {
            return "Scheme B";
        } else if (salary < 30000 && designation.equalsIgnoreCase("Associate")) {
            return "Scheme C";
        } else {
            return "No Scheme";
        }
    }

    @Override
    public String toString() {
        return "Employee ID: " + id +
                "\nName: " + name +
                "\nSalary: " + salary +
                "\nDesignation: " + designation +
                "\nInsurance Scheme: " + insuranceScheme;
    }
}
