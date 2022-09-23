package edu.mum.cs544.exe2.c;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {


    /**
     * Any database entity should not be null
     * so we must use class data-types to crate property
     * other than id
     * because our id is generated so there is no way makes it null

    * **/
    @Id
    @GeneratedValue
    private long id;

    private Long courseNumber;

    private String name;

    /**
     * Many to many association only implemented via join-table
    **/

    @ManyToMany(mappedBy="courses")

    private List<Student> students  = new ArrayList<>();


    public Long getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(Long courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
