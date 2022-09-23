package edu.mum.cs544;

import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {
         public Book get(Integer id);
         public List<Book> getAll();
         public Long add(Book book);
         public void update(Book book);
         public void delete(Integer id);

}
