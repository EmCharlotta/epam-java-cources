package com.epam.university.java.core.task019;

public class RobotImpl implements Robot {
    RobotPosition position;

    int north = 0;
    int south = 0;
    int west = 0;
    int east = 0;

    /**
     * constructor.
     */
    public RobotImpl() {
        this.position = new RobotPositionImpl();
        position.setX(0);
        position.setY(0);
    }

    @Override
    public RobotPosition getPosition() {
        return position;
    }

    @Override
    public void setPosition(RobotPosition position) {
        this.position = position;
    }

    @Override
    public void invokeAction(RobotCommand command) {

        if (north == 1 || (north == 0 && south == 0 && east == 0 && west == 0)) {

            if (command.equals(RobotCommand.MOVE_FORWARD)) {
                RobotPositionImpl pos = new RobotPositionImpl();
                pos.setY(getPosition().getY() + 1);
                pos.setX(getPosition().getX());
                setPosition(pos);
                north = 1;
            }
            if (command.equals(RobotCommand.TURN_RIGHT)) {
                north = 0;
                east = 1;
            }
            if (command.equals(RobotCommand.TURN_LEFT)) {
                north = 0;
                west = 1;
            }
        } else if (east == 1) {
            if (command.equals(RobotCommand.MOVE_FORWARD)) {
                RobotPositionImpl pos = new RobotPositionImpl();
                pos.setY(getPosition().getY());
                pos.setX(getPosition().getX() + 1);
                setPosition(pos);
            }
            if (command.equals(RobotCommand.TURN_RIGHT)) {
                east = 0;
                south = 1;
            }
            if (command.equals(RobotCommand.TURN_LEFT)) {
                east = 0;
                north = 1;
            }
        } else if (west == 1) {
            if (command.equals(RobotCommand.MOVE_FORWARD)) {
                RobotPositionImpl pos = new RobotPositionImpl();
                pos.setY(getPosition().getY());
                pos.setX(getPosition().getX() - 1);
                setPosition(pos);
            }
            if (command.equals(RobotCommand.TURN_RIGHT)) {
                west = 0;
                north = 1;
            }
            if (command.equals(RobotCommand.TURN_LEFT)) {
                west = 0;
                south = 1;
            }
        } else if (south == 1) {
            if (command.equals(RobotCommand.MOVE_FORWARD)) {
                RobotPositionImpl pos = new RobotPositionImpl();
                pos.setY(getPosition().getY() - 1);
                pos.setX(getPosition().getX());
                setPosition(pos);
            }
            if (command.equals(RobotCommand.TURN_RIGHT)) {
                west = 1;
                south = 0;
            }
            if (command.equals(RobotCommand.TURN_LEFT)) {
                east = 1;
                south = 0;
            }
        }
    }
}
