package com.iress.toyrobot.common.commands;

import com.iress.toyrobot.common.CommandTestHelper;
import com.iress.toyrobot.common.Direction;
import com.iress.toyrobot.common.Robot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReportCommandTest extends CommandTestHelper {
    private final ReportCommand reportCommand = new ReportCommand(Commands.REPORT);

    @Test
    void testReportIfRobotIsPlaced() {
        Robot robot = getRobot(1, 1, Direction.NORTH);
        reportCommand.execute(robot, getTable());
        Assertions.assertTrue(reportCommand.isSuccess());
        Assertions.assertEquals("1,1,NORTH", reportCommand.getReport(robot));
    }

    @Test
    void testReportifRobotIsNotPlaced() {
        Robot robot = new Robot();
        reportCommand.execute(robot, getTable());
        Assertions.assertFalse(reportCommand.isSuccess());
    }
}
