package com.example.librarymanagementsystem.controller;


import com.example.librarymanagementsystem.config.JwtAuthenticationFilter;
import com.example.librarymanagementsystem.dto.LoginRequest;
import com.example.librarymanagementsystem.dto.LoginResponse;
import com.example.librarymanagementsystem.dto.StandardResponse;
import com.example.librarymanagementsystem.entity.Book;
import com.example.librarymanagementsystem.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BookController {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final BookService bookService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest authenticationRequest) {
        try{
            LoginResponse authResponse = jwtAuthenticationFilter.authenticate(authenticationRequest);

            System.out.println("username: " + authenticationRequest.getUsername());
            System.out.println("jwt token: " + authResponse.getAccessToken());

            return ResponseEntity.ok(authResponse);
        } catch (AuthenticationServiceException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok("Welcome to the Stage 1 application!");
    }

    @GetMapping("/books")
    public ResponseEntity<StandardResponse> getBooks() {

        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.status(200).body(new StandardResponse("succes", null, books ));
        //return  bookService.getAllBooks();
    }
//    GET /api/books (כל הספרים)
//    - POST /api/books (הוספת ספר)
//    - PUT /api/books/{id} (עדכון)
//            - DELETE /api/books/{id} (מחיקה)
//            - POST /api/books/{id}/borrow (השאלה)
//    - POST /api/books/{id}/return (החזרה)

}
