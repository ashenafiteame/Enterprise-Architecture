package com.example.w2d1inheritance.complex;

import javax.persistence.*;

@Entity
public class Appointment {
    @Id
    private Long id;
    private String appdate;
    @ManyToOne
    private Patient patient;
    @Embedded
    private Payment payment;
    @ManyToOne
    private Doctor doctor;
}

