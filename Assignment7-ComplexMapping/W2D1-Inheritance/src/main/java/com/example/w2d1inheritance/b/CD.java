package com.example.w2d1inheritance.b;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CD")
public class CD extends Product{
private String artist;
}
