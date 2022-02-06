package com.iress.toyrobot.common;

import org.junit.jupiter.api.Assertions;

public class CommandTestHelper {

    private final Table table = new Table(5, 5);

    //Robot
    public Robot getRobot(Integer positionx, Integer positiony, Direction direction) {
        Position position = getPosition(positionx, positiony, direction);
        Robot robot = new Robot();
        robot.setPosition(position);
        return robot;
    }

    public Position getPosition(Integer positionx, Integer positiony, Direction direction) {
        return new Position(positionx, positiony, direction);
    }

    public Robot getRobot(Direction direction) {
        return getRobot(1, 1, direction);
    }

    public Table getTable() {
        return table;
    }

    public void assertPositions(Robot robot, Integer expectedX, Integer expectedY, Direction expectedDirection) {

        Assertions.assertEquals(expectedX, robot.getPosition().getX());
        Assertions.assertEquals(expectedY, robot.getPosition().getY());
        Assertions.assertEquals(expectedDirection, robot.getPosition().getDirection());
    }

}
