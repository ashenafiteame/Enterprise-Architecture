package edu.mum.cs544.exe2.a;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Set;


public class Employee {

    @Id
    private Integer employeeNumber;

    private String name;

    @ManyToOne
    private Department department;

    public Employee(Integer employeeNumber, String name) {
        this.employeeNumber = employeeNumber;
        this.name = name;
    }

    public Employee() {
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
