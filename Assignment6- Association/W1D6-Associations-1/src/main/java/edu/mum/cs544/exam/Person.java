package edu.mum.cs544.exam;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private Integer id;


    private String name;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Embedded
    private PhoneNumber number;

    @OneToMany
    @JoinColumn(name = "computers_id")
    private List<Computer> computers

            = new ArrayList<>();

}



