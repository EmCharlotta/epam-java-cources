package com.epam.university.java.core.task005;

public class PiHolderImpl implements PiHolder {

    int first;
    int second;

    @Override
    public int getFirst() {
        return first;
    }

    @Override
    public int getSecond() {
        return second;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public void setSecond(int second) {
        this.second = second;
    }
}
