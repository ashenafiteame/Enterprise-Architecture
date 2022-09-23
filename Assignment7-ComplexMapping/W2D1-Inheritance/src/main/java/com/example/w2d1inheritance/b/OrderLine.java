package com.example.w2d1inheritance.b;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderLine {
    @Id
    private Long id;
    private int quantity;
    @ManyToOne
    private Product products;
}
