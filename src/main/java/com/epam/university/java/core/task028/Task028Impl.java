package com.epam.university.java.core.task028;

public class Task028Impl implements Task028 {
    private int power;
    private int value;
    private int res;
    int base = 1;
    int total = 0;

    @Override
    public int getWays(int value, int power) {
        this.value = value;
        this.power = power;
        calculate(total, base);
        return res;
    }

    private void calculate(int total, int base) {
        int powerSum = (int) Math.pow(base, power);
        if (powerSum <= value - total) {
            calculate(total, base + 1);
            total += powerSum;
            if (total == value) {
                res++;
            } else if (total < value) {
                calculate(total, base + 1);
            }
        }
    }
}
