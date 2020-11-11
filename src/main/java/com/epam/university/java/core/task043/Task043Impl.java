package com.epam.university.java.core.task043;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Task043Impl implements Task043 {

    @Override
    public String encode(String sourceString) {
        try {
            Properties properties = new Properties();
            String[] words = sourceString.split(" ");
            String res = "";
            String fin = "";
            String line = "";
            try (InputStream input = Task043Impl.class.getClassLoader().getResourceAsStream(
                    "task043/morse.properties")) {
                properties.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (String str : words) {
                fin = "";
                char[] ch = str.toCharArray();
                for (char cha : ch) {
                    String s = String.valueOf(cha);
                    res = properties.getProperty(s);
                    if (fin.equals("")) {
                        fin = res;
                    } else {
                        fin = fin + " " + res;
                    }
                }
                if (line.equals("")) {
                    line = fin;
                } else {
                    line = line + "   " + fin;
                }
            }
            return line;
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String decode(String sourceString) {
        try {
            Properties properties = new Properties();
            String[] words = sourceString.split("   ");
            String res = "";
            String line = "";
            try (InputStream input = Task043Impl.class.getClassLoader().getResourceAsStream(
                    "task043/fromMorse.properties")) {
                properties.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (String str : words) {
                String fin = "";
                String[] letters = str.split(" ");
                for (String ltr : letters) {
                    String s = String.valueOf(ltr);
                    res = properties.getProperty(s);
                    if (fin.equals("")) {
                        fin = res;
                    } else {
                        fin = fin + res;
                    }
                }

                if (line.equals("")) {
                    line = fin;
                } else {
                    line = line + " " + fin;
                }
            }
            return line;
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }
}
