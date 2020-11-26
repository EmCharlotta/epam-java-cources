package com.epam.university.java.project.service;

import com.epam.university.java.project.core.cdi.impl.io.XmlResource;
import com.epam.university.java.project.core.cdi.io.Resource;
import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinition;
import com.epam.university.java.project.core.state.machine.manager.StateMachineManager;
import com.epam.university.java.project.domain.Book;
import com.epam.university.java.project.domain.BookEvent;
import com.epam.university.java.project.domain.BookStatus;

import java.time.LocalDate;
import java.util.Collection;

public class BookServiceImpl implements BookService {
    private BookDao bookDao;
    private final Resource stateMachineDefinitionXml;
    private StateMachineManager stateMachineManager;

    /**
     * Loading definition for BookStateMachine.
     */
    public BookServiceImpl() {
        final String contextPath = getClass()
                .getResource("/project/DefaultBookStateMachineDefinition.xml")
                .getFile();
        stateMachineDefinitionXml = new XmlResource(contextPath);
        bookDao = new BookDaoXmlImpl();
    }

    @Override
    public Book createBook() {
        @SuppressWarnings("unchecked")
        StateMachineDefinition<BookStatus, BookEvent> definition
                = (StateMachineDefinition<BookStatus, BookEvent>) stateMachineManager
                .loadDefinition(stateMachineDefinitionXml);

        Book book = bookDao.createBook();

        stateMachineManager.handleEvent(stateMachineManager.initStateMachine(book, definition),
                BookEvent.CREATE);

        return book;
    }

    @Override
    public Book getBook(int id) {
        return bookDao.getBook(id);
    }

    @Override
    public Collection<Book> getBooks() {
        return bookDao.getBooks();
    }

    @Override
    public void remove(Book book) {
        bookDao.remove(book);
    }

    @Override
    public Book save(Book book) {
        return bookDao.save(book);
    }

    @Override
    public Book accept(Book book, String number) {
        book.setSerialNumber(number);
        stateMachineManager.handleEvent(book, BookEvent.ACCEPT);
        return book;
    }

    @Override
    public Book issue(Book book, LocalDate returnDate) {
        book.setReturnDate(returnDate);
        stateMachineManager.handleEvent(book, BookEvent.ISSUE);
        return book;
    }

    @Override
    public Book returnFromIssue(Book book) {
        book.setReturnDate(null);
        stateMachineManager.handleEvent(book, BookEvent.RETURN);
        return book;
    }
}
