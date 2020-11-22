package com.epam.university.java.core.task044;

import java.util.ArrayList;
import java.util.List;

public class Task044Impl implements Task044 {
    @Override
    public int findCountOfTraces(Integer points, List<String> lines) {
        try {
            ArrayList<SomeVector> vectors = new ArrayList<>();
            for (String value : lines) {
                vectors.add(SomeVector.getSomeVector(value));
            }
            vectors.removeIf(vector -> vector.start == 1 || vector.end == 1);
            if (lines.size() == 0) {
                return points;
            } else {
                return points - (1 + vectors.size());
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }

    static class SomeVector {
        private int start;
        private int end;

        private SomeVector(int start, int end) {
            this.start = start;
            this.end = end;
        }

        static SomeVector getSomeVector(String value) {
            String[] numbers = value.split("\\s");
            int start = Integer.parseInt(numbers[0]);
            int end = Integer.parseInt(numbers[1]);
            return new SomeVector(start, end);
        }
    }
}