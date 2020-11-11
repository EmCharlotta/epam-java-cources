package com.epam.university.java.core.task011;

import java.util.ArrayList;
import java.util.LinkedList;

public class Task011Impl implements Task011 {
    @Override
    public String getLastName(String[] collection) {
        int startFrom2 = 0;
        try {
            while (collection.length > 1) {
                int k = 0;
                for (int i = 0 + startFrom2; i < collection.length; i += 2) {
                    collection[i] = "";
                    k++;
                }
                if (collection.length % 2 == 0) {
                    startFrom2 = 0;
                } else {
                    startFrom2 = 1;
                }

                String[] temp = new String[collection.length - k];
                int p = 0;
                for (int i = 0; i < collection.length; i++) {
                    if (collection[i] != "") {
                        temp[p] = collection[i];
                        p++;
                    }
                }
                collection = temp;
            }
            return collection[0];
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String getLastName(ArrayList<String> collection) {
        int startFrom2 = 0;
        try {
            while (collection.size() > 1) {
                int x = collection.size();
                for (int i = 0 + startFrom2; i < collection.size(); i++) {
                    collection.remove(i);
                }
                if (x % 2 == 0) {
                    startFrom2 = 0;
                } else {
                    startFrom2 = 1;
                }
            }
            return collection.get(0);
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String getLastName(LinkedList<String> collection) {
        int startFrom2 = 0;
        try {
            while (collection.size() > 1) {
                int x = collection.size();
                for (int i = 0 + startFrom2; i < collection.size(); i++) {
                    collection.remove(i);
                }
                if (x % 2 == 0) {
                    startFrom2 = 0;
                } else {
                    startFrom2 = 1;
                }
            }
            return collection.get(0);
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            throw new IllegalArgumentException();
        }
    }
}
