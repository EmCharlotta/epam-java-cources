package com.epam.university.java.core.task063;

public class Task063Impl implements Task063 {
    @Override
    public Integer calcDigitalRoot(Integer number) {
        if (number == null) {
            throw new IllegalArgumentException();
        }
        if (number < 10) {
            return number;
        }
        int toSum = 0;
        do {
            while (number > 9) {
                toSum += number % 10;
                number /= 10;
                if (number < 10) {
                    toSum = number + toSum;
                }
            }
            number = toSum;
            toSum = 0;
        } while (number > 9);
        return number;
    }
}
