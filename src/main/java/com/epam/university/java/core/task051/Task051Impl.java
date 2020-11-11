package com.epam.university.java.core.task051;

public class Task051Impl implements Task051 {
    @Override
    public String replace(String source) {

        try {
            if (source.toUpperCase().equals(source) || source.equals("the")) {
                throw new IllegalArgumentException();
            }
            source = source.replaceAll("the", "a");
            source = source.replaceAll("a\\s[a]", "an a");
            source = source.replaceAll("a\\s[e]", "an e");
            source = source.replaceAll("a\\s[y]", "an y");
            source = source.replaceAll("a\\s[u]", "an u");
            source = source.replaceAll("a\\s[i]", "an i");
            source = source.replaceAll("a\\s[o]", "an o");


        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
        return source;
    }
}
