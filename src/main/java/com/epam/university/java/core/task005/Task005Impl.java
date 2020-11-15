package com.epam.university.java.core.task005;

public class Task005Impl implements Task005 {
    @Override
    public PiHolder findPi(int digits) {
        if (digits < 1 || digits > 10) {
            throw new IllegalArgumentException();
        }
        PiHolderImpl piHolder = new PiHolderImpl();
        int one = 0;
        int two = 0;
        double res = 100;

        for (int i = (int) Math.pow(10, digits - 1); i < (int) Math.pow(10, digits) - 1; i++) {
            for (int j = (int) Math.pow(10, digits - 1); j < (double) i / 2; j++) {
                if (Math.abs((double) i / j - Math.PI) < res) {
                    one = i;
                    two = j;
                    res = Math.abs((double) i / j - Math.PI);
                }
            }
        }
        piHolder.setFirst(one);
        piHolder.setSecond(two);
        return piHolder;
    }
}

