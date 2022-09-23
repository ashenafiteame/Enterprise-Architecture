package com.example.w2d1inheritance.exam;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@SecondaryTable(name = "Owners")
public class Vehicle {

    @Id
    private Long id;

    @Column(table = "Owners")
    private String owner;

    @Column(name = "manufacturer")
    private String make;


    private String model;


    private int year;


    private String color;

    @OneToMany
    @JoinColumn
    @OrderColumn(name="wheels_ORDER") // name is optional
    private List<Wheel> wheels;

}


