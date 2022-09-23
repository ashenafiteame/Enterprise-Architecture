package edu.mum.cs544.exe2.e;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Office {
    @Id
    @GeneratedValue
    private long id;
    private Long roomNumber;
    private String building;
    @OneToMany(mappedBy = "office")
    private List<Employee> employee;
    public Office(Long roomNumber, String building) {
        this.roomNumber = roomNumber;
        this.building = building;
    }

    public Office() {
    }

}
