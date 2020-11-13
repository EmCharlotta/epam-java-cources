package com.epam.university.java.core.task019;

public class RobotPositionImpl implements RobotPosition {

    int x = 0;
    int y = 0;

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }
}
