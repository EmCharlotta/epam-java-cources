package com.epam.university.java.core.task004;

public class Task004Impl implements Task004 {
    @Override
    public String[] intersection(String[] first, String[] second) {
        int k = 0;
        String[] fin;
        try {
            fin = new String[first.length + second.length];
            for (int i = 0; i < first.length; i++) {
                for (int j = 0; j < second.length; j++) {
                    if (first[i].equals(second[j])) {
                        fin[k] = first[i];
                        k++;
                    }
                }
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
        String[] fina = new String[k];
        for (int i = 0; i < fina.length; i++) {
            fina[i] = fin[i];
        }
        return fina;
    }

    @Override
    public String[] union(String[] first, String[] second) {
        int d = 0;
        try {
            for (int i = 0; i < first.length; i++) {
                for (int j = 0; j < second.length; j++) {
                    if (first[i].equals(second[j])) {
                        second[j] = "0";
                        d++;
                    }
                }
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
        String[] fina = new String[first.length + second.length - d];
        for (int i = 0; i < first.length; i++) {
            fina[i] = first[i];
            System.out.println(fina[i]);
        }

        int k = 0;

        for (int i = 0; i < second.length; i++) {
            if (!second[i].equals("0")) {
                fina[first.length + k] = second[i];
                k++;
            }
        }
        return fina;
    }

}
