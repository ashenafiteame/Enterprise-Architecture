package com.example.w2d1inheritance.b;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "product_type",
discriminatorType = DiscriminatorType.STRING)
public abstract class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
}

