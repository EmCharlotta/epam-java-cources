package com.epam.university.java.core.task017;

import java.util.Formatter;
import java.util.Locale;

public class Task017Impl implements Task017 {
    @Override
    public String formatString(Object... args) {
        for (Object obj : args) {
            if (obj == null) {
                throw new IllegalArgumentException();
            }
        }
        try {
            Formatter formatter = new Formatter();
            return (formatter.format("You know %s, %s!", args[0], args[1]).toString());
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String formatNumbers(Object... args) {
        for (Object obj : args) {
            if (obj == null) {
                throw new IllegalArgumentException();
            }
        }
        try {
            Locale.setDefault(Locale.US);
            Formatter formatter1 = new Formatter();
            String a = formatter1.format("%.1f", args[0]).toString();
            Formatter formatter2 = new Formatter();
            String b = formatter2.format("%.2f", args[0]).toString();
            Formatter formatter3 = new Formatter();
            String c = formatter3.format("%+.2f", args[0]).toString();
            Formatter formatter4 = new Formatter();
            String d = formatter4.format("%a", args[0]).toString();
            String e = a + ", " + b + ", " + c + ", " + d;
            return e;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String formatDates(Object... args) {
        for (Object obj : args) {
            if (obj == null) {
                throw new IllegalArgumentException();
            }
        }
        try {
            Formatter formatter = new Formatter();
            return (formatter.format("%tY.%<td.%<tm", args[0]).toString());
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
    }
}
