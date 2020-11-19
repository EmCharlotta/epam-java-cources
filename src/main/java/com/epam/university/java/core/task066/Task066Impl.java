package com.epam.university.java.core.task066;

public class Task066Impl implements Task066 {
    @Override
    public long repeatString(String infiniteString, long limiter) {
        long res = 0;
        try {
            if (limiter < 0) {
                throw new IllegalArgumentException();
            }
            if (limiter > Integer.MAX_VALUE) {
                char[] ch = infiniteString.toCharArray();
                for (int i = 0; i < infiniteString.length(); i++) {
                    if (ch[i] == 'a') {
                        res++;
                    }
                }
                long mult = limiter / infiniteString.length();
                res *= mult;
                long cut = limiter % infiniteString.length();
                infiniteString = infiniteString.substring(0, (int) cut);
                ch = infiniteString.toCharArray();
                for (int i = 0; i < ch.length; i++) {
                    if (ch[i] == 'a') {
                        res++;
                    }
                }
                return res;
            }
            while (infiniteString.length() < limiter) {
                infiniteString = infiniteString.concat(infiniteString);
            }
            infiniteString = infiniteString.substring(0, (int) limiter);
            char[] ch = infiniteString.toCharArray();
            for (int i = 0; i < infiniteString.length(); i++) {
                if (ch[i] == 'a') {
                    res++;
                }
            }
            return res;
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }
}
