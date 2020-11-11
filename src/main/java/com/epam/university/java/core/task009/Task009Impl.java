package com.epam.university.java.core.task009;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.TreeSet;

public class Task009Impl implements Task009 {
    @Override
    public Collection<String> countWords(File sourceFile) {
        char[] buf = new char[2560];
        int c;
        TreeSet<String> set = new TreeSet<>();
        try (FileReader fileReader = new FileReader(sourceFile)) {
            while ((c = fileReader.read(buf)) > 0) {
                if (c < 2560) {
                    buf = Arrays.copyOf(buf, c);
                }
            }
            String b = new String(buf).replaceAll("[^a-zA-Z ]", "").trim();
            String[] strings = b.split("\\s+");
            for (String string : strings) {
                set.add(string.toLowerCase());
                System.out.println(string);
            }

        } catch (IOException | NullPointerException e) {
            throw new IllegalArgumentException();
        }

        return set;
    }

}
