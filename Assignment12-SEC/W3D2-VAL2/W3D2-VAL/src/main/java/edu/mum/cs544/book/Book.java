package edu.mum.cs544.book;

import org.hibernate.validator.constraints.ISBN;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank
    private String title;
    @ISBN
    private String ISBN;
    private String author;
    @Positive
    private double price;

    public Book() {
    }

    public Book(String title, String ISBN, String author, double price) {
        this.title = title;
        this.ISBN = ISBN;
        this.author = author;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
