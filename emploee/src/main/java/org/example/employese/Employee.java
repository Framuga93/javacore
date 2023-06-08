package org.example.employese;

public abstract class Employee {

    protected String name;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Employee(String name){
        this.name = name;
    }

    abstract double averageSalary();
}
