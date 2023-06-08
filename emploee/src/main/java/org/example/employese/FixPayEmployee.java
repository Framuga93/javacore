package org.example.employese;

public class FixPayEmployee extends Employee{
    private double fixSalary;
    public FixPayEmployee(String name, double fixSalary) {
        super(name);
        this.fixSalary = fixSalary;
    }

    @Override
    double averageSalary() {
        return fixSalary;
    }

    @Override
    public String toString() {
        return "FixPay Employee\n" +
                "name : " + name + '\n' +
                "Salary : " + averageSalary() + '\''+'\n';
    }
}
