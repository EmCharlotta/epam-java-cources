package com.epam.university.java.core.task003;

public class Task003Impl implements Task003 {
    @Override
    public String[] invert(String[] source) {
        String[] reverted;
        try {
            reverted = new String[source.length];
            for (int i = 0; i < source.length; i++) {
                reverted[i] = source[source.length - 1 - i];
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
        return reverted;
    }

    @Override
    public String[] join(String[] first, String[] second) {
        String[] merged;
        try {
            merged = new String[first.length + second.length];
            for (int i = 0; i < first.length; i++) {
                merged[i] = first[i];
            }
            for (int i = 0; i < second.length; i++) {
                merged[i + first.length] = second[i];
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
        return merged;
    }

    @Override
    public int findMax(int[] source) {
        int max;
        try {
            max = source[0];
            for (int i = 1; i < source.length; i++) {
                if (source[i] > max) {
                    max = source[i];
                }
            }
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
        return max;
    }

    @Override
    public String[] filter(String[] source, FilteringCondition condition) {
        int j = 0;
        String[] filtered;
        try {
            if (condition.equals(null)) {
                throw new IllegalArgumentException();
            }
            filtered = new String[source.length];
            for (int i = 0; i < source.length; i++) {
                if (condition.isValid(source[i])) {
                    filtered[j] = source[i];
                    j++;
                }
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
        String[] fin = new String[j];
        for (int i = 0; i < fin.length; i++) {
            fin[i] = filtered[i];
        }
        return fin;
    }

    @Override
    public String[] removeElements(String[] source, String[] toRemote) {
        String[] afterRemoval2;
        try {
            String[] afterRemoval = new String[source.length - toRemote.length];
            int j = 0;
            for (int i = 0; i < source.length; i++) {
                int num = 0;
                for (String strings : toRemote) {
                    if (source[i].equals(strings)) {
                        num++;
                    }
                }
                if (num == 0) {
                    afterRemoval[j] = source[i];
                    j++;
                }
            }
            afterRemoval2 = new String[j];
            for (int i = 0; i < j; i++) {
                afterRemoval2[i] = afterRemoval[i];
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
        return afterRemoval2;
    }

    @Override
    public String[] map(String[] source, MappingOperation operation) {
        String[] out;
        try {
            if (operation.equals(null)) {
                throw new IllegalArgumentException();
            }
            out = new String[source.length];
            for (int i = 0; i < source.length; i++) {
                out[i] = operation.map(source[i]);
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
        return out;
    }

    @Override
    public String[] flatMap(String[] source, FlatMappingOperation operation) {
        String one = "";
        try {
            if (operation.equals(null)) {
                throw new IllegalArgumentException();
            }
            int k = 0;
            for (String str : source) {
                if (str.equals("")) {
                    k++;
                }
            }
            if (k == source.length) {
                return source;
            }
            for (int i = 0; i < source.length; i++) {
                one = one + source[i] + ",";
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }

        return operation.flatMap(one);
    }
}

