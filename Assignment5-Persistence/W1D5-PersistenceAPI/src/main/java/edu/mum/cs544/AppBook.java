package edu.mum.cs544;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AppBook {
    public static EntityManagerFactory emf;

    public static void main(String[] args) {
        emf = Persistence.createEntityManagerFactory("cs544");

        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Book book1 = new Book("Atomic Habits", "1k2p14k2", "James Clear", 44.0, parseDate("2018-10-18"));
        em.persist(book1);

        Book book2 = new Book("Core Java", "fjaslkd", "Yemane Hadis", 33.0, parseDate("2014-02-24"));
        em.persist(book2);

        Book book3 = new Book("Core Spring ", "dfakjdfasdf", "Ashenafi Clear", 22.0, parseDate("2022-02-10"));
        em.persist(book3);
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        //retrive all books
        TypedQuery<Book> q = em.createQuery("from Book", Book.class);
        List<Book> bookList = q.getResultList();

        for (Book book : bookList) {
            System.out.println("Book name= " + book.getTitle() + " Author= " + book.getAuthor());

        }
        em.getTransaction().commit();
        em.close();

        em = emf.createEntityManager();
        em.getTransaction().begin();

        // update one book title and price

        TypedQuery<Book> allBookQuery = em.createQuery("from Book", Book.class);
        List<Book> allBookList = allBookQuery.getResultList();

        for (Book book : allBookList) {
            if (book.getTitle().equals("Atomic Habits")){
                book.setTitle("You can Win");
                book.setPrice(100.0);
            }
            else {
                em.remove(book);
            }
        }

        em.getTransaction().commit();
        em.close();

        //retrive all books
        em = emf.createEntityManager();
        em.getTransaction().begin();
        TypedQuery<Book> q4 = em.createQuery("from Book", Book.class);
        List<Book> bookList1 = q4.getResultList();

        for (Book book : bookList1) {
            System.out.println("Book name= " + book.getTitle() + " Author= " + book.getAuthor());

        }
        em.getTransaction().commit();
        em.close();


        // remove other book
        //em.remove();
//        em = emf.createEntityManager();
//        em.getTransaction().begin();
//        Book p1 = em.getReference(Book.class, 1);
//        em.remove(p1);
//        em.getTransaction().commit();
//        em.close();
//
//
//        //retrive all books
//        em = emf.createEntityManager();
//        em.getTransaction().begin();
//        TypedQuery<Book> q5 = em.createQuery("from Book", Book.class);
//        List<Book> bookList12 = q5.getResultList();
//
//        for (Book book : bookList12) {
//            System.out.println("Book name= " + book.getTitle() + " Author= " + book.getAuthor());
//
//        }
//        em.getTransaction().commit();
//        em.close();

    }

    public static Date parseDate(String date) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            return null;
        }
    }
}
