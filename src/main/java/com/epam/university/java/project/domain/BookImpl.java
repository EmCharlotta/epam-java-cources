package com.epam.university.java.project.domain;

import com.epam.university.java.project.core.state.machine.domain.StateMachineDefinition;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Random;

public class BookImpl implements Book {
    private int id;
    private String title;
    private Collection<String> authors;
    private String serialNumber;
    private LocalDate returnDate;
    private BookStatus state;
    private StateMachineDefinition<BookStatus, BookEvent> definition;

    public BookImpl() {
        Random random = new Random();
        this.id = 1 + random.nextInt(100);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public Collection<String> getAuthors() {
        return authors;
    }

    @Override
    public void setAuthors(Collection<String> authors) {
        this.authors = authors;
    }

    @Override
    public String getSerialNumber() {
        return serialNumber;
    }

    @Override
    public void setSerialNumber(String value) {
        this.serialNumber = value;
    }

    @Override
    public LocalDate getReturnDate(LocalDate returnDate) {
        return null;
    }

    @Override
    public void setReturnDate(LocalDate date) {
        this.returnDate = date;
    }

    @Override
    public BookStatus getState() {
        return state;
    }

    @Override
    public void setState(BookStatus bookStatus) {
        this.state = bookStatus;
    }

    @Override
    public StateMachineDefinition<BookStatus, BookEvent> getStateMachineDefinition() {
        return definition;
    }

    @Override
    public void setStateMachineDefinition(StateMachineDefinition<BookStatus,
            BookEvent> definition) {
        this.definition = definition;
    }
}