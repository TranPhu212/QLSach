package com.example.demo.service;

import com.example.demo.model.Book;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private List<Book> books = new ArrayList<>();
    private int nextId = 1;

    public List<Book> getAllBooks() {
        return books;
    }

    public void addBook(Book book) {
        book.setId(nextId++);
        books.add(book);
    }

    public Optional<Book> getBookById(int id) {
        return books.stream().filter(b -> b.getId() == id).findFirst();
    }

    public void updateBook(Book updatedBook) {
        books.stream()
            .filter(b -> b.getId() == updatedBook.getId())
            .findFirst()
            .ifPresent(b -> {
                b.setTitle(updatedBook.getTitle());
                b.setAuthor(updatedBook.getAuthor());
            });
    }

    public void deleteBook(int id) {
        books.removeIf(b -> b.getId() == id);
    }
}