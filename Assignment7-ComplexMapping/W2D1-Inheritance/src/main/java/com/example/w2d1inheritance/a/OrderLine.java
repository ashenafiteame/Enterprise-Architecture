package com.example.w2d1inheritance.a;

import javax.persistence.Id;
import javax.persistence.ManyToOne;


public class OrderLine {
    @Id
    private Long id;
    private int quantity;
    @ManyToOne
    private Product products;
}
