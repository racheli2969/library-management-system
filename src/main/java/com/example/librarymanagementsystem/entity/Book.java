package com.example.librarymanagementsystem.entity;

import com.example.librarymanagementsystem.dto.BookDto;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter @Setter
@RequiredArgsConstructor
@ToString
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 100)
    private  String author;

    /*International Standard Book Number (ISBN) is a unique 13-digit identifier assigned to each specific edition of a book or similar publication*/
    @Column(nullable = false, unique = true)
    private Integer isbn;

    @Column(nullable = false)
    private Category category;

    @Column(nullable = false)
    private  boolean available;

    /*id of the user who borrowed the book*/
    private  long borrowedBy;

    public Book(BookDto bookDto) {
        this.title = bookDto.getTitle();
        this.author = bookDto.getAuthor();
        this.isbn = bookDto.getIsbn();
        this.category = bookDto.getCategory();
        this.available = true;
    }
}