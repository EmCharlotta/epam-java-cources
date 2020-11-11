package com.epam.university.java.core.task002;

public class Task002Impl implements Task002 {

    @Override
    public boolean isEquals(String firstString, String secondString) {
        boolean isEqual;
        try {
            if (secondString.equals(null)) {
                throw new IllegalArgumentException();
            }
            isEqual = firstString.equals(secondString);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Введите обе строки");
        }
        return isEqual;
    }

    @Override
    public String left(String sourceString, int number) {
        String sub;
        try {
            if (number < 0) {
                throw new IllegalArgumentException();
            }
            if (number > sourceString.length()) {
                number = sourceString.length();
            }
            sub = sourceString.substring(0, number);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Введите строку и число");
        }
        return sub;
    }

    @Override
    public String left(String sourceString, String separator) {

        String one;
        try {
            String[] strings = sourceString.split(separator);
            one = strings[0];
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Введите строку и сепаратор");
        }
        return one;
    }

    @Override
    public String right(String sourceString, int number) {
        String sub;
        if (number < 0) {
            throw new IllegalArgumentException();
        }
        try {
            if (number > sourceString.length()) {
                number = sourceString.length();
            }
            sub = sourceString.substring(sourceString.length() - number, sourceString.length());
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Введите строку и число");
        }
        return sub;
    }

    @Override
    public String right(String sourceString, String separator) {
        String two;
        try {
            String[] strings = sourceString.split(separator);
            two = strings[1];
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Введите строку и сепаратор");
        } catch (ArrayIndexOutOfBoundsException e) {
            return sourceString;
        }
        return two;
    }

    @Override
    public String[] split(String sourceString, String split) {
        String[] strings;
        try {
            strings = sourceString.split(split);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException("Введите строку и сепаратор");
        }
        return strings;
    }

    @Override
    public String join(String[] sourceCollection, String glue) {
        String sum;
        try {
            for (String str : sourceCollection) {
                if (str.equals(null) || glue.equals(null) || str.equals("")) {
                    throw new IllegalArgumentException();
                }
            }
            sum = sourceCollection[0];
            for (int i = 1; i < sourceCollection.length; i++) {
                sum = sum + glue + sourceCollection[i];
            }
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("введите строки и клей");
        }
        return sum;
    }
}
