package com.epam.university.java.core.task023;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task023Impl implements Task023 {
    @Override
    public String extract(String phoneString) {
        try {
            Pattern pattern = Pattern.compile(
                    "^\\+?[7,8]\\s?\\(?\\-?\\d{3}\\)?\\s?\\-?\\d{3}\\s?\\-?\\d{2}\\s?\\-?\\d{2}");
            Matcher matcher = pattern.matcher(phoneString);
            String res = "";
            while (matcher.find()) {
                res = phoneString.substring(matcher.start(), matcher.end());
            }
            if (res.equals("")) {
                throw new IllegalArgumentException();
            }

            Pattern pat = Pattern.compile("^\\+?[7,8]\\s?\\(?\\-?\\d{3}");
            Matcher mat = pat.matcher(res);
            while (mat.find()) {
                res = res.substring(mat.start(), mat.end());
            }
            Pattern patt = Pattern.compile("\\d{3,4}");
            Matcher matc = patt.matcher(res);
            while (matc.find()) {
                res = res.substring(matc.start(), matc.end());
            }
            if (res.startsWith("7") || res.startsWith("8")) {
                res = res.substring(1, 4);
            }
            return res;
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }
}
