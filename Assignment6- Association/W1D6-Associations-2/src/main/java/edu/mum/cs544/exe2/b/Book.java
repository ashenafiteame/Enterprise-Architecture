package edu.mum.cs544.exe2.b;

import javax.persistence.*;
import java.util.Optional;

public class Book {
    @Id
    @GeneratedValue
    private  long id;

    private String isbn;

    private String title;

    private  String author;

    @ManyToOne
//    @JoinColumn(name = "publisherid")

    // if we create publisher-book table
    // there will not be null
    // but if we create new column it may be null
    // snice publisher is optional
    //@JoinTable(name = "book-publisher")
    private Publisher publisher;
    public Book() {
    }

    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public long getId() {
        return id;
    }



    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public Optional getPublisher(){
        return Optional.ofNullable(this.publisher);
    }

    public void setPublisher(final Publisher publisher){
        this.publisher = publisher;
    }

}
