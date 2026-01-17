package com.lab_assignment_2.q4;
import java.util.ArrayList;
import com.lab_assignment_2.q5.Payable;

abstract class Employee implements Payable {
    protected String name;
    protected int employeeId;

    public Employee(String name, int employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }
}


public class Q4 {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new SalariedEmployee("Ram", 101, 800));
        employees.add(new HourlyEmployee("Shyam", 102, 40, 20));
        employees.add(new CommissionEmployee("sita", 103, 10, 5000));

        for(Employee emp : employees) {
            System.out.println("Employee: " + emp.getName() +" | Weekly Salary: Rs" + emp.getPayment());
        }
    }
}
