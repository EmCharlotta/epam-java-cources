package com.epam.university.java.core.task026;

import com.epam.university.java.core.task043.Task043Impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Properties;

public class Task026Impl implements Task026 {


    @Override
    public String encrypt(String sourceString, int shift) {
        try {
            Properties properties = new Properties();
            try (InputStream input = Task026Impl.class.getClassLoader().getResourceAsStream(
                    "task026/letters.properties")) {
                properties.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
            char[] chars = sourceString.toCharArray();
            char[] result = new char[chars.length];
            for (int i = 0; i < chars.length; i++) {
                if (!Character.isLetter(chars[i])) {
                    result[i] = chars[i];
                } else {
                    String s = String.valueOf(chars[i]).toLowerCase();
                    String number = properties.getProperty(s);
                    int temp = Integer.parseInt(number);
                    Integer res = temp + shift;
                    while (res > 26) {
                        res -= 26;
                    }
                    String re = properties.getProperty(res.toString());
                    if (!s.equals(String.valueOf(chars[i]))) {
                        re = re.toUpperCase();
                    }
                    result[i] = re.charAt(0);
                }
            }
            return String.valueOf(result);

        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String decrypt(String encryptedString, int shift) {
        try {
            Properties properties = new Properties();
            try (InputStream input = Task026Impl.class.getClassLoader().getResourceAsStream(
                    "task026/letters.properties")) {
                properties.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
            char[] chars = encryptedString.toCharArray();
            char[] result = new char[chars.length];
            for (int i = 0; i < chars.length; i++) {
                if (!Character.isLetter(chars[i])) {
                    result[i] = chars[i];
                } else {
                    String s = String.valueOf(chars[i]).toLowerCase();
                    String number = properties.getProperty(s);
                    int temp = Integer.parseInt(number);
                    while (shift > 26) {
                        shift -= 26;
                    }
                    Integer res = temp - shift + 26;
                    while (res > 26) {
                        res -= 26;
                    }
                    String re = properties.getProperty(res.toString());
                    if (!s.equals(String.valueOf(chars[i]))) {
                        re = re.toUpperCase();
                    }
                    result[i] = re.charAt(0);
                }
            }
            return String.valueOf(result);

        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }
}
