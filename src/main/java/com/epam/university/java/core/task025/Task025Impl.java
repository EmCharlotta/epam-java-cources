package com.epam.university.java.core.task025;

public class Task025Impl implements Task025 {
    @Override
    public int getAmountOfAlteredLetters(String sourceMessage) {
        int k = 0;
        try {
            for (int i = 0; i < sourceMessage.length(); i++) {
                if (i == 1 || (i - 1) % 3 == 0) {
                    if (sourceMessage.toCharArray()[i] != 'O') {
                        k++;
                    }
                }
                if (i == 0 || i == 2 || i % 3 == 0 || (i - 2) % 3 == 0) {
                    if (sourceMessage.toCharArray()[i] != 'S') {
                        k++;
                    }
                }
            }
            return k;
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }
}
