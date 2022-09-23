package com.example.w2d1inheritance.exam;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Wheel {
    @Id
    private Long id;
    private int size;
    private double pressure;
}
