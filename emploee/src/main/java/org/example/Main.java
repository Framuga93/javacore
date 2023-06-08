package org.example;

import org.example.employese.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        FixPayEmployee employee = new FixPayEmployee("Иван", 12000);
        HourlyPayEmployee employee2 = new HourlyPayEmployee("Степан", 12);
        FixPayEmployee employee3 = new FixPayEmployee("Алексей", 15000);
        HourlyPayEmployee employee4 = new HourlyPayEmployee("Геннадий", 45);
        FixPayEmployee employee5 = new FixPayEmployee("Бурик", 45000);
        HourlyPayEmployee employee6 = new HourlyPayEmployee("рек", 67);
        FixPayEmployee employee7 = new FixPayEmployee("Аван", 45000);
        HourlyPayEmployee employee8 = new HourlyPayEmployee("Степан", 23);

        System.out.println(employee);
        System.out.println(employee2);

        List<Employee> listEmp = new ArrayList<>();
        EmpolyeeListClass employeeList = new EmpolyeeListClass();
        employeeList.addEmployee(employee);
        employeeList.addEmployee(employee2);
        employeeList.addEmployee(employee3);
        employeeList.addEmployee(employee4);
        employeeList.addEmployee(employee5);
        employeeList.addEmployee(employee6);
        employeeList.addEmployee(employee7);
        employeeList.addEmployee(employee8);


        Comparator<Employee> comparator = new EmployeeComparator.EmployeeSalaryComparator()
                .thenComparing(new EmployeeComparator.EmployeeNameComparator());
        listEmp.sort(comparator);
        System.out.println(employeeList);

        employeeList.showEmployee();


    }
}