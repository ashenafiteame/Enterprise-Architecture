package edu.mum.cs544.exam;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;


@Embeddable
public class PhoneNumber {
    private String number;
    private String type;

}
