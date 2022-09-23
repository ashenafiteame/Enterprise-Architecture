package edu.mum.cs544.exe2.d;

import javax.persistence.*;
import java.util.Date;

@Entity

public class Reservation {

    @Id
    @GeneratedValue
    private long id;


    private Date date;


    @ManyToOne
    private Book book;


}
