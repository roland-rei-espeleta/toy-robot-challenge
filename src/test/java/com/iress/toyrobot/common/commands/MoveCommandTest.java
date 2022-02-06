package com.iress.toyrobot.common.commands;

import com.iress.toyrobot.common.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.iress.toyrobot.common.Direction.*;

public class MoveCommandTest extends CommandTestHelper {

    private final MoveCommand moveCommand = new MoveCommand(Commands.MOVE);

    @Test
    void testMoveSouth() {
        Robot robot = getRobot(SOUTH);
        moveCommand.execute(robot, getTable());
        Assertions.assertEquals(robot.getPosition().getX(), 1);
        Assertions.assertEquals(robot.getPosition().getY(), 0);
    }

    @Test
    void testMoveNorth() {
        Robot robot = getRobot(NORTH);
        moveCommand.execute(robot, getTable());
        Assertions.assertEquals(robot.getPosition().getX(), 1);
        Assertions.assertEquals(robot.getPosition().getY(), 2);
    }

    @Test
    void testMoveEast() {
        Robot robot = getRobot(EAST);
        moveCommand.execute(robot, getTable());
        Assertions.assertEquals(robot.getPosition().getX(), 2);
        Assertions.assertEquals(robot.getPosition().getY(), 1);
    }

    @Test
    void testMoveWest() {
        Robot robot = getRobot(WEST);
        moveCommand.execute(robot, getTable());
        Assertions.assertEquals(robot.getPosition().getX(), 0);
        Assertions.assertEquals(robot.getPosition().getY(), 1);
    }

    @Test
    void testMoveIfRobotIsNotPlacedShouldNotExecute() {
        Robot robot = new Robot();
        moveCommand.execute(robot, getTable());
        Assertions.assertFalse(moveCommand.isSuccess());
    }

    @Test
    void testMoveIfPositionIsOutsideTheTable() {
        Robot robot = getRobot(5, 5, NORTH);
        moveCommand.execute(robot, getTable());
        Assertions.assertFalse(moveCommand.isSuccess());
    }
}

