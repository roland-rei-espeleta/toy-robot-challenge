package com.iress.toyrobot.common.commands;

import com.iress.toyrobot.common.Position;
import com.iress.toyrobot.common.Robot;
import com.iress.toyrobot.common.Table;

public class RightCommand extends BaseCommand{

    public RightCommand(Commands commands) {
        super(null, commands);
    }

    @Override
    public void execute(Robot robot, Table table) {
        if(robot.isPlaced()) {
            success();
            robot.setPosition(new Position(robot.getPosition().getX(), robot.getPosition().getY(), robot.getPosition().getDirection()).turnRight());
        } else {
            error();
        }
    }
}
