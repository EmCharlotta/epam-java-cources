package com.epam.university.java.core.task047;

public class Task047Impl implements Task047 {
    @Override
    public long calculateInversions(int n, int[] a) {
        int k = 0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = a.length - 1; j > i; j--) {
                if (a[i] > a[j]) {
                    k++;
                }

            }
        }
        return k;
    }
}
