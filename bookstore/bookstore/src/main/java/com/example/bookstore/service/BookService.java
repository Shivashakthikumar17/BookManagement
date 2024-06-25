package com.example.bookstore.service;
import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service

public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
    public Optional<Book> getBooksById(Long id){
        return bookRepository.findById(id);
    }
    public Book addBook(Book book){
        return bookRepository.save(book);
    }
    public Book updateBook(Long id,Book bookDetails){
        Optional<Book> existingBook = bookRepository.findById(id);
        if (existingBook.isPresent()) {
            Book book = existingBook.get();
            book.setTitle(bookDetails.getTitle());
            book.setAuthor(bookDetails.getAuthor());
            book.setDescription(bookDetails.getDescription());
            book.setPublishedDate(bookDetails.getPublishedDate());
            return bookRepository.save(book);
    }else {
        throw new RuntimeException("Book Not Found:"+id);
        }
    }
    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }


}
