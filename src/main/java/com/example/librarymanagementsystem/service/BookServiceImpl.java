package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.dto.BookDto;
import com.example.librarymanagementsystem.dto.StandardResponse;
import com.example.librarymanagementsystem.entity.Book;
import com.example.librarymanagementsystem.entity.Category;
import com.example.librarymanagementsystem.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService{
private final BookRepository bookRepository;

//    public ResponseEntity<StandardResponse> getAllBooks(){
//        List<Book> books = bookRepository.findAll();
//        return ResponseEntity.status(200).body(new StandardResponse("succes", null, books ));
//       // return bookRepository.findAll();
//    }
    public List<Book> getAllBooks(){
         return bookRepository.findAll();
    }

    //needs to be for admin
    public void saveBook(BookDto bookDto) {
        Book book = new Book(bookDto);
//        Book b = new Book();
//        b.setTitle(bookDto.getTitle());
//        b.setAuthor(bookDto.getAuthor());
//        b.setIsbn(bookDto.getIsbn());
//        b.setCategory(bookDto.getCategory());
//        b.setAvailable(true);
          bookRepository.save(book);
    }

    //needs to be for admin
    public void deleteBook(long id, long userId) {
        bookRepository.deleteById(id);
    }

    public void borrowBook(long bookId, long borrowedBy) {

            bookRepository.findById(bookId).ifPresent(book -> {
                if(book.isAvailable()){
                    book.setBorrowedBy(borrowedBy);
                    bookRepository.save(book);
                  //  return "successfully borrowed book";

                }
            });
    }

    public void returnBook(Long id) {
        bookRepository.findById(id).ifPresent(book -> {
            book.setAvailable(false);
            bookRepository.save(book);
        });

    }
    public List<Book> searchBooks(String text) {
        return bookRepository.findAll().stream().filter(book -> book.getTitle().toLowerCase().contains(text.toLowerCase())).collect(Collectors.toList());
    }
    public List<Book> searchBooks(Category category) {
        return bookRepository.findAll().stream().filter(book -> book.getCategory().equals(category)).collect(Collectors.toList());
    }
}
