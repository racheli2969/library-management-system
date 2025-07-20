package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.dto.BookDto;
import com.example.librarymanagementsystem.dto.StandardResponse;
import com.example.librarymanagementsystem.entity.Book;
import com.example.librarymanagementsystem.entity.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Collectors;

public interface BookService {

    public List<Book> getAllBooks();
    //public ResponseEntity<StandardResponse> getAllBooks();
    //needs to be for admin
    public void saveBook(BookDto bookDto);
    //needs to be for admin
    public void deleteBook(long id, long userId);
    public void borrowBook(long bookId, long borrowedBy);
    public void returnBook(Long id);
    public List<Book> searchBooks(String text);
    public List<Book> searchBooks(Category category);

}
