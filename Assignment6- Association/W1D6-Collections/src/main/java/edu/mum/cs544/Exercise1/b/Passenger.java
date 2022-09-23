package edu.mum.cs544.Exercise1.b;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Passenger {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private  String name;
    @OneToMany
    private List<Flight> flights= new ArrayList<>();

    public Passenger() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Passenger(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
