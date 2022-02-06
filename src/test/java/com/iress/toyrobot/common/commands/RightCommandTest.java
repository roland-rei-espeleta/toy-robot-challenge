package com.iress.toyrobot.common.commands;

import com.iress.toyrobot.common.Direction;
import com.iress.toyrobot.common.Robot;
import com.iress.toyrobot.common.CommandTestHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RightCommandTest extends CommandTestHelper {

    private final RightCommand command = new RightCommand(Commands.RIGHT);

    @Test
    void testRightCommandIfRobotIsPlaced() {
        Robot robot = getRobot(Direction.NORTH);
        command.execute(robot, getTable());
        Assertions.assertEquals(Direction.EAST, robot.getPosition().getDirection());
    }

    @Test
    void testRightCommandIfRobotIsNotPlaced() {
        Robot robot = new Robot();
        command.execute(robot, getTable());
        Assertions.assertFalse(command.isSuccess());
    }
}
