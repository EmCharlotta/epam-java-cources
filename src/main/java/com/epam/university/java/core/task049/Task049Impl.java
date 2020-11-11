package com.epam.university.java.core.task049;

import java.util.ArrayList;

public class Task049Impl implements Task049 {
    @Override
    public String getResultList(String first, String second) {
        try {
            if (first.trim().equals("") && second.trim().equals("")) {
                throw new IllegalArgumentException();
            }
            ArrayList<String> res = new ArrayList<>();
            for (int i = 0; i < first.length(); i++) {
                for (int j = 0; j < second.length(); j++) {
                    if (first.toCharArray()[i] == second.toCharArray()[j]) {
                        int k = i;
                        int l = j;
                        while (first.toCharArray()[k] == second.toCharArray()[l]) {
                            res.add(String.valueOf(first.toCharArray()[k]));
                            k++;
                            l++;
                            if (k == first.length() || l == second.length()) {
                                String result = "";
                                for (String string : res) {
                                    result = result.concat(string);
                                }
                                return result;
                            }
                        }
                        return String.valueOf(first.toCharArray()[k - 1]);
                    }
                }
            }
            return String.valueOf(res);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }
}