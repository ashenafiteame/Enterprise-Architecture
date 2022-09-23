package edu.mum.cs544.Exercise1.a;

import javax.persistence.*;

@Entity
public class Laptop {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String brand;
    private String type;
    @ManyToOne(cascade = CascadeType.ALL)
    private Employee employee;


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        employee.getLaptops().add(this);
        this.employee = employee;
    }



    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Laptop(String brand, String type) {
        this.brand = brand;
        this.type = type;
    }

    public Laptop() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
