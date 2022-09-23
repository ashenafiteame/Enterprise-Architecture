package edu.mum.cs544.exe2.c;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
public class Student {

    @Id
    private Long studentID;

    private String firstName;

    private String lastName;

    @ManyToMany(
            cascade = {CascadeType.PERSIST,CascadeType.REMOVE}
    )
    @JoinTable(
            name = "enrolment",
            joinColumns = @JoinColumn(
                    name = "student_id",
                    foreignKey = @ForeignKey(name = "enrolment_student_id_fk")
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "course_id",
                    foreignKey = @ForeignKey(name = "enrolment_course_id_fk")
            )
    )
    private List<Course> courses  = new ArrayList<>();

    public Student() {
        /**
         * this is for Hibernate
         * because it uses java reflection to
         * create an object so, it needs a default constructor
         * **/
    }

    public Student(Long studentID, String firstName, String lastName, List<Course> courses) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.courses = courses;
    }

    public Long getStudentID() {
        return studentID;
    }

    public void setStudentID(Long studentID) {
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean addCourse(Course course){
        if (courses.add(course)){
            return true;
        }
        return false;
    }
    public boolean removeCourses(Course course){
        if (courses.remove(course)){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", courses=" + courses +
                '}';
    }
}
