package com.epam.university.java.core.task003;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class FlatMappingOperationImpl implements FlatMappingOperation {
    @Override
    public String[] flatMap(String source) {
        String delimeter = ",";
        String[] two = source.split(delimeter);
        for (int i = 0; i < two.length; i++) {
            two[i] = two[i].trim();
        }
        int[] numbers = new int[two.length];
        for (int i = 0; i < two.length; i++) {
            int a = Integer.parseInt(two[i]);
            numbers[i] = a;
        }
        Integer[] integers = Arrays.stream(numbers).boxed().sorted(Collections.reverseOrder())
                .toArray(Integer[]::new);
        Set<Integer> set = new LinkedHashSet<Integer>(Arrays.asList(integers));
        Integer[] fin = set.toArray(Integer[]::new);
        String[] finn = new String[fin.length];
        for (int j = 0; j < fin.length; j++) {
            finn[j] = fin[j].toString();
        }
        return finn;
    }
}
