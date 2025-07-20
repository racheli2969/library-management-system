package com.example.librarymanagementsystem.repository;

import com.example.librarymanagementsystem.entity.Book;
import com.example.librarymanagementsystem.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByAuthor(String author);
    Book findByAvailable(boolean available);
    Book findByTitleContaining (String word);
    Book findByCategory (Category category);
}
