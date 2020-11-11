package com.epam.university.java.core.task022;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Task022Impl implements Task022 {
    @Override
    public int maxSum(Collection<Integer> numbers) {
        try {
            Integer min = Collections.min(numbers);
            Integer sum = 0;
            Iterator iter = numbers.iterator();
            while (iter.hasNext()) {
                sum = sum + (int) iter.next();
            }
            sum = sum - min;
            return sum;
        } catch (NullPointerException | NoSuchElementException e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public int minSum(Collection<Integer> numbers) {
        try {
            Integer max = Collections.max(numbers);
            Integer sum = 0;
            Iterator iter = numbers.iterator();
            while (iter.hasNext()) {
                sum = sum + (int) iter.next();
            }

            sum = sum - max;
            return sum;
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }
}
