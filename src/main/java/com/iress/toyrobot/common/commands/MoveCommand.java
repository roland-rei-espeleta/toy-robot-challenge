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
            Position currentPosition = new Position(robot.getPosition().getX(), robot.getPosition().getY(), robot.getPosition().getDirection());
            currentPosition.getDirection().move(currentPosition);
            if(table.isValidAction(currentPosition)) {
                success();
                robot.setPosition(currentPosition);
            } else {
                error();
                System.out.println("Robot will fall off with the move command!");
            }
        } else {
            error();
        }
    }
}
