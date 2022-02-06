package com.iress.toyrobot.common.commands;

import com.iress.toyrobot.common.Position;
import com.iress.toyrobot.common.Robot;
import com.iress.toyrobot.common.Table;

public class PlaceCommand extends BaseCommand  {

    public PlaceCommand(Position position, Commands commands) {
        super(position, commands);
    }

    public void execute(Robot robot, Table table) {
        if(table.isValidAction(getPosition())) {
            success();
            robot.setPosition(getPosition());
        } else {
            error();
        }
    }
}
