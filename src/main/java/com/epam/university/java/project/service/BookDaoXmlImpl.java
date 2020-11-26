package com.epam.university.java.project.service;

import com.epam.university.java.project.domain.Book;
import com.epam.university.java.project.domain.BookImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class BookDaoXmlImpl implements BookDao {
    private final Collection<Book> collectionOfBooks = new ArrayList<>();

    @Override
    public Book createBook() {
        return new BookImpl();
    }

    @Override
    public Book getBook(int id) {
        Optional<Book> book = collectionOfBooks.stream()
                .filter(x -> x.getId() == id)
                .findAny();
        return book.orElse(null);
    }

    @Override
    public Collection<Book> getBooks() {
        return collectionOfBooks;
    }

    @Override
    public void remove(Book book) {
        if (getBook(book.getId()) != null) {
            collectionOfBooks.remove(book);
        } else {
            throw new RuntimeException("No book found");
        }
    }

    @Override
    public Book save(Book book) {
        collectionOfBooks.add(book);
        return book;
    }
}