package com.example.w2d1inheritance.b;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("DVD")
public class DVD extends Product {
    private String genre;

}
