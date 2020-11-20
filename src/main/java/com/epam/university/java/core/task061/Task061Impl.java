package com.epam.university.java.core.task061;

import com.google.gson.internal.LinkedTreeMap;

import java.util.Iterator;
import java.util.Set;

public class Task061Impl implements Task061 {
    @Override
    public String convertToRoman(int number) {
        if (number < 1 || number > 3999) {
            throw new IllegalArgumentException();
        }
        String roman = "";
        while (number > 999) {
            roman = roman.concat("M");
            number -= 1000;
        }
        if (number > 899) {
            roman = roman.concat("CM");
            number -= 900;
        } else if (number > 499) {
            roman = roman.concat("D");
            number -= 500;
        } else if (number > 399) {
            roman = roman.concat("CD");
            number -= 400;
        }
        while (number > 99) {
            roman = roman.concat("C");
            number -= 100;
        }
        if (number > 89) {
            roman = roman.concat("XC");
            number -= 90;
        } else if (number > 49) {
            roman = roman.concat("L");
            number -= 50;
        } else if (number > 39) {
            roman = roman.concat("XL");
            number -= 40;
        }
        while (number > 9) {
            roman = roman.concat("X");
            number -= 10;
        }
        if (number > 8) {
            roman = roman.concat("IX");
            number -= 9;
        } else if (number > 5) {
            roman = roman.concat("V");
        }
        while (number > 0) {
            roman = roman.concat("I");
            number -= 1;
        }
        return roman;
    }

    @Override
    public int convertToArabic(String number) {
        LinkedTreeMap<String, Integer> map = new LinkedTreeMap<>();
        map.put("M", 1000);
        map.put("CM", 900);
        map.put("D", 500);
        map.put("CD", 400);
        map.put("C", 100);
        map.put("XC", 90);
        map.put("L", 50);
        map.put("XL", 40);
        map.put("X", 10);
        map.put("IX", 9);
        map.put("V", 5);
        map.put("IV", 4);
        map.put("I", 1);
        try {
            Set<String> keySet = map.keySet();
            int res = 0;
            char[] ch = number.toCharArray();
            for (int i = 0; i < ch.length; i++) {
                if (!keySet.contains(String.valueOf(ch[i]))) {
                    throw new IllegalArgumentException();
                }
            }
            while (number.length() > 0) {
                Iterator<String> iterator = keySet.iterator();
                while (iterator.hasNext()) {
                    String value = iterator.next();
                    if (number.startsWith(value)) {
                        res += map.get(value);
                        number = number.replaceFirst(value, "");
                        break;
                    }
                }
            }
            return res;
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }
}
