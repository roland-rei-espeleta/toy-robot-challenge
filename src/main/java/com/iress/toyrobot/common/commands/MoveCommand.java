package com.iress.toyrobot.common.commands;

import com.iress.toyrobot.common.Position;
import com.iress.toyrobot.common.domain.Robot;
import com.iress.toyrobot.common.domain.Table;

public class MoveCommand extends BaseCommand {

    public MoveCommand(Commands commands) {
        super(null, commands);
    }

    @Override
    public void execute(Robot robot, Table table) {

        if(robot.isPlaced()) {
            Position curr_position = new Position(robot.getPosition().getX(), robot.getPosition().getY(), robot.getPosition().getDirection());
            curr_position.getDirection().move(curr_position);
            if(table.isValidAction(curr_position)) {
                success();
                robot.setPosition(curr_position);
            } else {
                error();
                System.out.println("Robot will fall off with the move command!");
            }
        } else {
            error();
        }
    }
}
