package com.epam.university.java.core.task019;

public class Task019Impl implements Task019 {

    @Override
    public void invokeAction(Robot robot, RobotCommand command) {

        try {
            robot.invokeAction(command);
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean isOnStartPosition(Robot robot) {
        try {
            if (robot.getPosition().getX() == 0 && robot.getPosition().getY() == 0) {
                return true;
            }
            return false;
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }
}
