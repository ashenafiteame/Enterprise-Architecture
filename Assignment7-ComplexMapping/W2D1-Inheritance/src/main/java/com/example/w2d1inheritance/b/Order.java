package com.example.w2d1inheritance.b;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
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
