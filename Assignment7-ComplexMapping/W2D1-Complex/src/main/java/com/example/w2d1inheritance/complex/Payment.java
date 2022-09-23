package com.example.w2d1inheritance.complex;

import javax.persistence.Embeddable;

@Embeddable
public class Payment {
    private String paydate;
    private double amount;
}
