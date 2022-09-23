package edu.mum.cs544.exe2.d;


import javax.persistence.*;
import java.util.List;
@Entity

public class Customer {

    @Id
    @GeneratedValue
    private long id;

    private String name;

    @OneToMany
    @JoinColumn()
    private List<Reservation> reservations;

    public Customer(String name) {
        this.name = name;
    }



    public Customer() {
    }
}
