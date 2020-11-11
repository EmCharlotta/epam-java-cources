package com.epam.university.java.core.task033;

public class Task033Impl implements Task033 {
    @Override
    public void doSomething(int first, int second) {

        if (first > second) {
            throw new GreaterExceptionImpl("First > Second", new BaseExpectionImpl());
        }
        if (second > first) {
            throw new LessExceptionImpl("Second > First", new BaseExpectionImpl());
        }
        if (first == 0 || second == 0) {
            throw new ArithmeticException();
        }
    }
}