package edu.mum.cs544;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class ConsoleApp implements CommandLineRunner {
    @Autowired
    private BookService bookService;

    @Override
    public void run(String... args) throws Exception {
        Book newBook = new Book("Anna Karina","12345678","LEO-TELOSTOY",12.0);
        System.out.println();
        System.out.println(bookService.getAll());
        Book bookTobeUpdated = new Book("Anna Karina","12345678","LEO-TELOSTOY",18.00);
        bookTobeUpdated.setId(4);
        bookService.update(bookTobeUpdated);
        bookService.delete(2);
        System.out.println(bookService.getAll());
    }
}
