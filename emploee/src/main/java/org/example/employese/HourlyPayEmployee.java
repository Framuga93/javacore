package org.example.employese;

import java.text.DecimalFormat;

public class HourlyPayEmployee extends Employee{
    private double hourlySalary;
    public HourlyPayEmployee(String name, double hourlySalary) {
        super(name);
        this.hourlySalary = hourlySalary;
    }

    @Override
    double averageSalary() {
        return this.hourlySalary*20.8*8;
    }

    @Override
    public String toString() {
        String salary = new DecimalFormat("#0.00").format(averageSalary());
        return "HourlyPay Employee\n" +
                "name : " + name + "\n" +
                "Salary : " + salary + '\''+'\n';
    }
}
