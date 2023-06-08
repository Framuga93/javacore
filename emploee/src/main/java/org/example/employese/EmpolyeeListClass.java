package org.example.employese;

import java.util.ArrayList;
import java.util.List;

public class EmpolyeeListClass {
    public List<Employee> empolyeeList;

    
    public EmpolyeeListClass(){
        List<Employee> empList = new ArrayList<>();
        this.empolyeeList = empList;
    }
    public void addEmployee(Employee emp){
        this.empolyeeList.add(emp);
    }

    public void showEmployee(){
        for(Employee emp : this.empolyeeList){
            System.out.println(emp);
        }
    }
}
