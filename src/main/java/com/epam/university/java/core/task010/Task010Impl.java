package com.epam.university.java.core.task010;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Task010Impl implements Task010 {
    @Override
    public Map<String, Integer> countWordNumbers(File source) {
        char[] buf = new char[2560];
        int c;
        Map<String, Integer> map = new TreeMap<>();
        try (FileReader fileReader = new FileReader(source)) {
            while ((c = fileReader.read(buf)) > 0) {
                if (c < 2560) {
                    buf = Arrays.copyOf(buf, c);
                }
            }
            String b = new String(buf).replaceAll("[^a-zA-Z ]", "").trim().toLowerCase();
            String[] strings = b.split("\\s+");
            for (String string : strings) {
                if (!map.containsKey(string)) {
                    map.put(string, 1);
                } else {
                    map.put(string, map.get(string) + 1);
                }
            }

        } catch (IOException | NullPointerException e) {
            throw new IllegalArgumentException();
        }

        return map;
    }
}
