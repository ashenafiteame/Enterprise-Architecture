package edu.mum.cs544;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookService {
    @Resource
    private IBookDao bookDao;

    public List<Book> getAll() {
        return bookDao.findAll();
    }

    public void add(Book book) {
        bookDao.save(book);
    }

    public Book get(int id) {
        return bookDao.getById(id);
    }

    public void update(Book book) {
        bookDao.save(book);
    }

    public void delete(int id) {
        Book b=bookDao.getById(id);
        bookDao.delete(b);
    }
}
