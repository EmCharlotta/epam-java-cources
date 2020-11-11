package com.epam.university.java.core.task045;

public class Task045Impl implements Task045 {
    @Override
    public String doAnagram(String input) {
        try {

            String[] words = input.split(" ");
            for (int i = 0; i < words.length; i++) {
                words[i].trim();
                char[] res = new char[words[i].length()];
                char[] ch = words[i].toCharArray();
                for (int j = 0; j < words[i].length(); j++) {
                    if (!Character.isLetter(ch[j])) {
                        res[j] = ch[j];
                    }
                }
                String n = new String(res);
                System.out.println("digits " + n);
                for (int j = 0; j < words[i].length(); j++) {
                    if (Character.isLetter(ch[j])) {
                        for (int u = words[i].length() - 1; u >= 0; u--) {
                            if (res[u] == (char) 0) {
                                res[u] = ch[j];
                                break;
                            }
                        }
                    }

                    System.out.println(res);
                }
                words[i] = new String(res);
                System.out.println(words[i]);
            }

            String b = String.join(" ", words);
            if (b.trim().equals("")) {
                return input;
            }
            return b;
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }
}
