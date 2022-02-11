package com.iress.toyrobot.common.commands;

import com.iress.toyrobot.common.Direction;
import com.iress.toyrobot.common.domain.Robot;
import com.iress.toyrobot.common.CommandTestHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeftCommandTest extends CommandTestHelper {

    private final LeftCommand command = new LeftCommand(Commands.LEFT);

    @Test
    void testLeftCommandIfRobotIsPlaced() {
        Robot robot = getRobot(Direction.NORTH);
        command.execute(robot, getTable());
        Assertions.assertEquals(Direction.WEST, robot.getPosition().getDirection());
    }

    @Test
    void testLeftCommandIfRobotIsNotPlaced() {
        Robot robot = new Robot();
        command.execute(robot, getTable());
        Assertions.assertFalse(command.isSuccess());
    }
}
