package com.iress.toyrobot.common.commands;

import com.iress.toyrobot.common.domain.Robot;
import com.iress.toyrobot.common.domain.Table;

public class ReportCommand extends BaseCommand {

    public ReportCommand(Commands commands) {
        super(null, commands);
    }

    @Override
    public void execute(Robot robot, Table table) {
        if(robot.getPosition() != null) {
            success();
            System.out.println(getReport(robot));
        } else {
            error();
            System.out.println("Robot not placed!");
        }
    }

    public String getReport(Robot robot) {
        return robot.report();
    }
}
