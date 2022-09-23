package edu.mum.cs544.exam;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Computer {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "cpu")
    private double CpuSpeed;
    private int ram;

}
