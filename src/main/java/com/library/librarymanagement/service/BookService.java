
package com.library.librarymanagement.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.library.librarymanagement.model.Book;

@Service
public class BookService {

    // ArrayList to store books
    private List<Book> books = new ArrayList<>();

    // Add Book
    public Book addBook(Book book) {

        books.add(book);
        return book;
    }

    // Get All Books
    public List<Book> getAllBooks() {

        return books;
    }

    // Get Book By ID
    public Book getBookById(int id) {

        for (Book book : books) {

            if (book.getId() == id) {
                return book;
            }
        }

        return null;
    }

    // Update Book
    public Book updateBook(int id, Book updatedBook) {

        Book existingBook = getBookById(id);

        if (existingBook != null) {

            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setCategory(updatedBook.getCategory());
            existingBook.setAvailableCopies(
                    updatedBook.getAvailableCopies());

            return existingBook;
        }

        return null;
    }

    // Delete Book
    public boolean deleteBook(int id) {

        Book book = getBookById(id);

        if (book != null) {

            books.remove(book);
            return true;
        }

        return false;
    }
}
