package com.iress.toyrobot.common.commands;

import com.iress.toyrobot.common.CommandTestHelper;
import com.iress.toyrobot.common.Direction;
import com.iress.toyrobot.common.domain.Robot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlaceCommandTest extends CommandTestHelper {

    @Test
    void testIfRobotIsPlacedAfterFirstPlaceCommand() {
        Robot robot = new Robot();
        PlaceCommand placeCommand = getPlaceCommand(0, 0, Direction.SOUTH);
        placeCommand.execute(robot, getTable());

        Assertions.assertTrue(placeCommand.isSuccess());
        assertPositions(robot, 0, 0, Direction.SOUTH);
    }

    @Test
    void testIfRobotIsPlacedAgainAfterSecondPlaceCommand() {
        Robot robot = new Robot();
        PlaceCommand placeCommand = getPlaceCommand(0, 0, Direction.SOUTH);
        placeCommand.execute(robot, getTable());

        Assertions.assertTrue(placeCommand.isSuccess());
        assertPositions(robot, 0, 0, Direction.SOUTH);

        PlaceCommand secondCommand = getPlaceCommand(2, 2, Direction.NORTH);
        secondCommand.execute(robot, getTable());
        Assertions.assertTrue(secondCommand.isSuccess());
        assertPositions(robot, 2, 2, Direction.NORTH);
    }

    @Test
    void testIfRobotWillNotBePlacedOnPositionOutsideTheTable() {
        Robot robot = new Robot();
        PlaceCommand placeCommand = getPlaceCommand(6, 6, Direction.SOUTH);
        placeCommand.execute(robot, getTable()); // Default is 5x5
        Assertions.assertFalse(placeCommand.isSuccess());
    }

    private PlaceCommand getPlaceCommand(Integer x, Integer y, Direction direction) {
        return new PlaceCommand(getPosition(x, y, direction),Commands.PLACE);
    }


}
