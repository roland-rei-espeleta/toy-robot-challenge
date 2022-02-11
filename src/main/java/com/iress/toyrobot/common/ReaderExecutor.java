package com.iress.toyrobot.common;

import com.iress.toyrobot.common.exceptions.ToyRobotException;

public interface ReaderExecutor {

    CommandReader getCommandReader();

    default void execute() throws ToyRobotException{
        CommandExecutor commandExecutor = new CommandExecutor(getCommandReader().readCommands());
        commandExecutor.execute();
    }
}
