package com.example.w2d1inheritance.complex;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;

@Entity
@SecondaryTable(name = "Address_table")
public class Patient {
    @Id
    private Long id;
    private String name;
    @Column(table = "Address_table")
    private String street;
    @Column(table = "Address_table")
    private String zip;
    @Column(table = "Address_table")
    private String city;
}
