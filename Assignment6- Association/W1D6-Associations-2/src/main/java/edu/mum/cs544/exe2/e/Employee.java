package edu.mum.cs544.exe2.e;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private long id ;

    private Long employeeNumber;

    private String name;

    @ManyToOne
    private Office office;

    @ManyToOne
    Department department;

}
