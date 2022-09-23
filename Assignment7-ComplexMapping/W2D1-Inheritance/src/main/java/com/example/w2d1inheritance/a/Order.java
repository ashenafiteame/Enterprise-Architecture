package com.example.w2d1inheritance.a;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Table(name = "Order_table")
public class Order {
    @Id
    private Long orderId;
    private Date date;
    @ManyToOne
    private Customer customer;

    @OneToMany
    @JoinColumn
    private List<OrderLine> orderLine;
}
