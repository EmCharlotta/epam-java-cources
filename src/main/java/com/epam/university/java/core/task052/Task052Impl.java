package com.epam.university.java.core.task052;

public class Task052Impl implements Task052 {
    @Override
    public boolean validateCard(long number) {
        if (number <= 0) {
            throw new IllegalArgumentException();
        }
        final long check = number % 10;
        number = number / 10;
        long[] longers = new long[String.valueOf(number).length()];
        for (int i = 0; i < longers.length; i++) {
            longers[i] = number % 10;
            number = number / 10;
        }
        long sum = 0;
        for (int i = 0; i < longers.length; i++) {
            if (i % 2 != 0) {
                longers[i] = longers[i] * 2;
                if (longers[i] > 9) {
                    longers[i] = longers[i] / 10 + longers[i] % 10;
                }
            }
            sum = sum + longers[i];
        }
        if (10 - sum % 10 == check) {
            return true;
        }
        return false;
    }

}
