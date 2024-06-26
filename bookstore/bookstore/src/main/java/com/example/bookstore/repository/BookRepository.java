package com.example.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookstore.model.Book;
import org.springframework.stereotype.Repository;

@Repository

public interface BookRepository extends JpaRepository<Book, Long> {
}
