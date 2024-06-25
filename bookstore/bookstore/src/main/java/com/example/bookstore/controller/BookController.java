package com.example.bookstore.controller;
import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import com.example.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController

public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(value="/get")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }
    @GetMapping(value="/get/{id}")
    public Optional<Book>getBooksById(@PathVariable Long id){
        return bookService.getBooksById(id);
    }
    @PostMapping(value = "/add")
    public  Book addBook(@RequestBody Book book){
        System.out.println("Hello");
        return bookService.addBook(book);
    }
    @PutMapping("/details/{id}")
    public Book updateBook(@PathVariable Long id,@RequestBody Book bookDetails){
        return bookService.updateBook(id,bookDetails);
    }
    @DeleteMapping("/delete/{id}")
    public   Book deleteBook(@PathVariable Long id){
        bookService.deleteBook(id);
        return null;
    }
}
