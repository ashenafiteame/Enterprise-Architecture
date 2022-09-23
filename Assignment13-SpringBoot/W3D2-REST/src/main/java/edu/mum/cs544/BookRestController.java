package edu.mum.cs544;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@RestController
public class BookRestController {
    @Resource
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/book")
    public Optional<Book> get(@PathVariable int id) {
        return bookService.get(id);
    }

    @PostMapping("/book")
    public RedirectView add(@RequestBody Book book) {
        long id = bookService.add(book);
        return new RedirectView("/book/" + id);
    }

    @PutMapping("/books")
    public void update(@RequestBody Book book) {
        bookService.update(book);
    }

    @DeleteMapping("/books")
    public void delete(@PathVariable int id) {
        bookService.delete(id);
    }

}
