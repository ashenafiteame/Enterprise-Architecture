package com.example.w2d1inheritance.a;

import javax.persistence.Id;


public class Product {
    @Id
    private Long id;
    private String name;
    private String description;
}
