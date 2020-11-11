package com.epam.university.java.core.task027;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Task027Impl implements Task027 {
    @Override
    public Collection<Integer> extract(String sourceString) {
        try {
            ArrayList<Integer> res = new ArrayList<>();
            int j = 0;
            int m = 0;
            for (int q = 1; q < sourceString.length() / 2; q++) {
                for (int i = 0; i < sourceString.length(); i = i + q) {
                    if ((i + q + j) > sourceString.length()) {
                        res.add(14834);
                        break;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(sourceString);
                    int num = Integer.parseInt(stringBuilder.substring(i, i + q + j));
                    if (j == 1) {
                        j = 0;
                        m = 1;
                        q++;
                    }
                    res.add(num);
                    if (num % 9 == 0 && num != 0) {
                        j = 1;
                    }
                }
                if (m == 1) {
                    m = 0;
                    q--;
                }
                int z = 0;
                for (int a = 0; a < res.size() - 1; a++) {
                    if (res.get(a) == res.get(a + 1) - 1) {
                        z++;
                    }
                }
                if (z == res.size() - 1 && res.get(0) != 0) {
                    return res;
                } else {
                    res = new ArrayList<>();
                }
            }
            return Collections.emptyList();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }
}
