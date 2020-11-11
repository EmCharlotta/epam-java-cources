package com.epam.university.java.core.task008;

import java.util.LinkedList;

public class Task008Impl implements Task008 {
    @Override
    public boolean isValid(String sourceString) {
        try {
            LinkedList<Character> check = new LinkedList<>();
            for (Character ch : sourceString.toCharArray()) {
                if (ch == '(' || ch == '{' || ch == '[') {
                    check.add(ch);
                }
                if ((ch == ')' || ch == '}' || ch == ']') && check.size() == 0) {
                    check.add('e');
                } else if (ch == ')') {
                    if (check.getLast() == '(') {
                        check.removeLast();
                    }
                } else if (ch == '}') {
                    if (check.getLast() == '{') {
                        check.removeLast();
                    }

                } else if (ch == ']') {
                    if (check.getLast() == '[') {
                        check.removeLast();
                    }

                }
            }
            if (check.size() == 0) {
                return true;
            } else {
                return false;
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }
}
