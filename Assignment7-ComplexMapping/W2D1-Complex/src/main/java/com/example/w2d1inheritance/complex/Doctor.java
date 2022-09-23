package com.example.w2d1inheritance.complex;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Doctor {
    @Id
    private Long id;
    @Column(name = "type")
    private String doctortype;
    private String firstname;
    private String lastname;
}
