package edu.mum.cs544;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class BookServiceProxy implements BookService{
    @Autowired
    private RestTemplate restTemplate;
    private final String bookUrl = "http://localhost:9191/books/{id}";
    private final String booksUrl = "http://localhost:9191/books/";


    @Override
    public Book get(Integer id) {
       return restTemplate.getForObject(bookUrl,Book.class,id);

    }
    @Override
    public List<Book> getAll() {
        ResponseEntity<List<Book>> books =
                restTemplate
                        .exchange(
                                booksUrl,
                                HttpMethod.GET,
                                null,
                                new ParameterizedTypeReference<List<Book>>(){}
                        );
        return books.getBody();
    }

    @Override
    public Long add(Book book) {
        URI uri = restTemplate.postForLocation(booksUrl,book);
        if (uri == null) return null;
        Matcher m = Pattern.compile(".*/book/(\\d+)").matcher(uri.getPath());
        m.matches();
        return Long.parseLong(m.group(1));

    }

    @Override
    public void update(Book book) {
        restTemplate.put(bookUrl,book,book.getId());
    }

    @Override
    public void delete(Integer id) {
        restTemplate.delete(bookUrl,id);
    }
}
