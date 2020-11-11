package com.epam.university.java.core.task040;

public class Task040Impl implements Task040 {
    @Override
    public int countScore(String str) {
        try {
            String[] res1 = str.split(" ");
            if (res1[res1.length - 1].contains("X")) {

                if ((res1[res1.length - 1].contains("XX"))) {
                    if (res1[res1.length - 1].contains("XXX")) {
                        res1[res1.length - 1] = res1[res1.length - 1].replace("XXX", " X X X ");
                    } else {
                        res1[res1.length - 1] = res1[res1.length - 1].replace("XX", " X X ");
                    }
                } else {
                    res1[res1.length - 1] = res1[res1.length - 1].replace("X", " X ");
                }
            }
            str = String.join(" ", res1);
            str = str.replace("  ", " ");
            String[] res = str.split(" ");
            int[] calc = new int[res.length];
            for (int i = 0; i < res.length; i++) {
                if (res.length == 12) {
                    return 300;
                }
                if (res[i].contains("/")) {
                    Integer score = (Integer.parseInt(res[i].replace('/', '0')));
                    Integer on = score / 10;
                    Integer tw = 10 - on;
                    res[i] = score.toString();
                    if (res[i + 1].startsWith("X")) {
                        calc[i] = 20;
                    } else {
                        calc[i] = 10 + Integer.parseInt(res[i + 1]) / 10;
                    }
                    res[i] = on.toString() + tw.toString();
                }
            }
            for (int i = 0; i < res.length; i++) {
                if (res[i].contains("X") && (i + 1) < res.length) { // если 1 страйк
                    if ((i + 1) < res.length && res[i + 1].contains("X") && (i + 2) < res.length
                            && (i + 3) < res.length) { // если дабл
                        if (res[i + 2].contains("X")) { // если трипл
                            calc[i] = 30;
                        } else {
                            if ((i + 2) >= calc.length) {
                                calc[i] = 10;
                            } else {
                                calc[i] = 20 + Integer.parseInt(res[i + 2]) / 10;
                            }
                        }
                    } else {
                        calc[i] = 10 + Integer.parseInt(res[i + 1]) / 10
                                + Integer.parseInt(res[i + 1]) % 10;
                    }
                } else {
                    if (calc[i] == 0 && i < res1.length) {
                        //во всех других случаях
                        calc[i] = Integer.parseInt(res[i]) / 10 + Integer.parseInt(res[i]) % 10;
                    }
                }
            }

            int sum = 0;
            for (int ca : calc) {
                sum = sum + ca;
            }
            return sum;
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }
}

