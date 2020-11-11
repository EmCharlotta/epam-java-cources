package com.epam.university.java.core.task048;

import java.util.ArrayList;
import java.util.Collection;

public class Task048Impl implements Task048 {
    @Override
    public Collection<Integer> getArmstrongNumbers(Integer from, Integer to) {
        try {
            if (from < 0 && to < 0) {
                throw new IllegalArgumentException();
            }
            ArrayList<Integer> integers = new ArrayList<>();
            for (int i = from; i <= to; i++) {
                int pow = String.valueOf(i).length();
                int digit = i;
                int sum = 0;
                for (int a = 0; a < pow; a++) {
                    int d = digit % 10;
                    digit = digit / 10;
                    sum = (int) Math.pow(d, pow) + sum;
                }
                if (sum == i) {
                    integers.add(sum);
                }
            }
            return integers;
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }
}
