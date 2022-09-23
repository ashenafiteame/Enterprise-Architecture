package edu.mum.cs544.Exercise1.c;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.HashMap;
import java.util.Map;

@Entity
public class School {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;

    @OneToMany
    private Map<Long,Student> students= new HashMap<>();

    public School() {
    }

    public School(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
