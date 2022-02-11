package com.iress.toyrobot.common.commands;

import com.iress.toyrobot.common.Position;
import com.iress.toyrobot.common.domain.Robot;
import com.iress.toyrobot.common.domain.Table;

public class LeftCommand extends BaseCommand {

    public LeftCommand(Commands commands) {
        super(null, commands);
    }

    @Override
    public void execute(Robot robot, Table table) {

        if(robot.isPlaced()) {
            success();
            robot.setPosition(new Position(robot.getPosition().getX(), robot.getPosition().getY(), robot.getPosition().getDirection()).turnLeft());
        } else {
            error();
        }
    }
}
