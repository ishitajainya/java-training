package com.lab_assignment_2.q4;


public class SalariedEmployee extends Employee {
    private double weeklySalary;

    public SalariedEmployee(String name, int employeeId, double weeklySalary) {
        super(name, employeeId);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double getPayment() {
        return weeklySalary;
    }
}