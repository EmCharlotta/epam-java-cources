package com.epam.university.java.core.task001;

public class Task001Impl implements Task001 {

    @Override
    public double addition(String firstNumber, String secondNumber) {
        try {
            if (firstNumber.equals("") || secondNumber.equals("")) {
                throw new IllegalArgumentException();
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
        double first = Double.parseDouble(firstNumber);
        double second = Double.parseDouble(secondNumber);
        return (first + second);
    }

    @Override
    public double subtraction(String firstNumber, String secondNumber) {
        try {
            if (firstNumber.equals("") || secondNumber.equals("")) {
                throw new IllegalArgumentException();
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
        double first = Double.parseDouble(firstNumber);
        double second = Double.parseDouble(secondNumber);
        return (first - second);
    }

    @Override
    public double multiplication(String firstNumber, String secondNumber) {
        try {
            if (firstNumber.equals("") || secondNumber.equals("")) {
                throw new IllegalArgumentException();
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
        double first = Double.parseDouble(firstNumber);
        double second = Double.parseDouble(secondNumber);
        return (first * second);
    }

    @Override
    public double division(String firstNumber, String secondNumber) {
        try {
            if (firstNumber.equals("") || secondNumber.equals("")) {
                throw new IllegalArgumentException();
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }


        double first = Double.parseDouble(firstNumber);
        double second = Double.parseDouble(secondNumber);
        return ((double) first / second);
    }
}
