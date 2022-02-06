package com.iress.toyrobot.common.commands;

import com.iress.toyrobot.common.RawCommand;
import com.iress.toyrobot.common.Robot;
import com.iress.toyrobot.common.Table;

public class CommandError extends BaseCommand  {

    private final RawCommand rawCommand;

    public CommandError(RawCommand rawCommand, Commands commands) {
        super(null, commands);
        this.rawCommand = rawCommand;
    }

    @Override
    public void execute(Robot robot, Table table) {
        error();
        System.out.println("Invalid command!!! Command : " + rawCommand.toString());
    }
}
