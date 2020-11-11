package com.epam.university.java.core.task007;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class Task007Impl implements Task007 {
    @Override
    public Collection<Integer> multiplyPolynomial(Collection<Integer> first,
                                                  Collection<Integer> second) {
        try {
            Integer[] one = new Integer[first.size()];
            Integer[] two = new Integer[second.size()];
            Iterator iterator = first.iterator();
            int i = 0;
            while (iterator.hasNext()) {
                one[first.size() - i - 1] = (int) iterator.next();
                i++;
            }

            iterator = second.iterator();
            i = 0;
            while (iterator.hasNext()) {
                two[second.size() - i - 1] = (int) iterator.next();
                i++;
            }

            Integer[] res = new Integer[one.length + two.length - 1];
            for (int k = 0; k < one.length; k++) {
                for (int j = 0; j < two.length; j++) {
                    if (res[k + j] != null) {
                        res[k + j] = res[k + j] + one[k] * two[j];
                        System.out.println("test");
                    } else {
                        res[k + j] = one[k] * two[j];
                    }
                }
            }

            ArrayList<Integer> fin = new ArrayList<>();
            for (int a = 0; a < res.length; a++) {
                fin.add(res[res.length - a - 1]);
            }

            return fin;
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }
}
