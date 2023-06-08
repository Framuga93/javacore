package org.example.employese;

import java.util.Comparator;

public class EmployeeComparator {


    public static class EmployeeNameComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee employee1, Employee employee2) {
            return employee1.getName().compareTo(employee2.getName());
        }
    }

    public static class EmployeeSalaryComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee employee1, Employee employee2) {

            return Double.compare(employee2.averageSalary(), employee1.averageSalary());
        }
    }
}

