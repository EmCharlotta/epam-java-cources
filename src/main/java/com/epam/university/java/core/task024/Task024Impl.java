package com.epam.university.java.core.task024;

import java.util.ArrayList;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task024Impl implements Task024 {
    @Override
    public Collection<String> getWordsCount(String source) {
        try {
            Pattern pattern = Pattern.compile("[a-z,A-Z,а-я, А-ЯÜÄÖ][a-z, а-яüäöß]*");
            Matcher matcher = pattern.matcher(source);
            ArrayList<String> res = new ArrayList<>();
            while (matcher.find()) {
                String result = source.substring(matcher.start(), matcher.end()).toLowerCase();
                res.add(result);
            }
            if (res.equals(null)) {
                throw new IllegalArgumentException();
            }
            res.trimToSize();
            return res;
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }
}
