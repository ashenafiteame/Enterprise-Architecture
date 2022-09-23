package edu.mum.cs544.exe2.e;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue
    private long  id;


    private String name;


    @OneToMany(mappedBy = "department")
    List<Employee> employees;










}
