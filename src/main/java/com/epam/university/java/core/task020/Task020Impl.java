package com.epam.university.java.core.task020;

import java.util.Arrays;
import java.util.Collection;

public class Task020Impl implements Task020 {
    @Override
    public int calculate(Collection<String> stones) {
        try {
            Object[] sto = stones.toArray();
            String[] coincide = compareTwo(sto[0].toString(), sto[1].toString());
            for (int i = 2; i < sto.length; i++) {
                coincide = compareTwo(Arrays.toString(coincide), sto[i].toString());
            }
            int q = 0;
            for (int i = 0; i < coincide.length; i++) {
                if (coincide[i] != null) {
                    q++;
                }
            }
            String[] fin = new String[q];
            int c = 0;
            for (int i = 0; i < coincide.length; i++) {
                if (coincide[i] != null) {
                    fin[c] = coincide[i];
                    c++;
                }
            }
            for (int a = 0; a < fin.length; a++) {
                for (int h = a + 1; h < fin.length; h++) {
                    if (fin[a].equals(fin[h])) {
                        fin[a] = null;
                        q--;
                        break;
                    }
                }
            }
            return q;
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Compares 2 gemstones.
     *
     * @param stone1 stones collection
     * @param stone2 stones collection
     * @return common parts
     */
    public String[] compareTwo(String stone1, String stone2) {
        String[] res = new String[stone1.length()];
        int k = 0;
        for (int i = 0; i < stone1.length(); i++) {
            for (int j = 0; j < stone2.length(); j++) {
                if (stone1.toCharArray()[i] == stone2.toCharArray()[j]) {
                    k++;
                    res[i] = String.valueOf(stone1.toCharArray()[i]);
                    break;
                }
            }
        }
        return res;
    }
}
