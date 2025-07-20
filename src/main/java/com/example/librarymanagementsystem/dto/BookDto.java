package com.example.librarymanagementsystem.dto;

import com.example.librarymanagementsystem.entity.Category;
import jakarta.persistence.Column;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class BookDto {
    @NotBlank(message = "please provide book title")
    private String title;

    @NotBlank(message = "please provide book author")
    private  String author;

    /**International Standard Book Number (ISBN) is a unique 13-digit identifier assigned to each specific edition of a book or similar publication*/
    @NotBlank(message = "please provide book ISBN")
    private Integer isbn;

    @NotBlank(message = "please provide book category")
    private Category category;
}
