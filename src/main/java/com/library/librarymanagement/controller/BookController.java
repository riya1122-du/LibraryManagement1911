
package com.library.librarymanagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.library.librarymanagement.model.Book;
import com.library.librarymanagement.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    // Constructor Injection
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    // (a) Add Book - POST
    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {

        Book savedBook = bookService.addBook(book);

        return new ResponseEntity<>(
                savedBook, HttpStatus.CREATED);
    }

    // (b) Get All Books - GET
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {

        return ResponseEntity.ok(
                bookService.getAllBooks());
    }

    // (c) Get Book By ID - GET
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(
            @PathVariable int id) {

        Book book = bookService.getBookById(id);

        if (book != null) {
            return ResponseEntity.ok(book);
        }

        return ResponseEntity.notFound().build();
    }

    // (d) Update Book - PUT
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(
            @PathVariable int id,
            @RequestBody Book book) {

        Book updatedBook = bookService.updateBook(id, book);

        if (updatedBook != null) {
            return ResponseEntity.ok(updatedBook);
        }

        return ResponseEntity.notFound().build();
    }

    // (e) Delete Book - DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(
            @PathVariable int id) {

        boolean deleted = bookService.deleteBook(id);

        if (deleted) {
            return ResponseEntity.ok(
                    "Book deleted successfully!");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Book not found!");
    }
}
