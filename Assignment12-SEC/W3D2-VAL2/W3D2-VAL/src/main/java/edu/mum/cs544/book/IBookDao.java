package edu.mum.cs544.book;



import java.util.List;

public interface IBookDao {

    public abstract List<Book> allBooks();

    public abstract void add(Book book);

    public abstract Book get(int id);

    public abstract void update(Book book);

    public abstract void delete(int id);
}
