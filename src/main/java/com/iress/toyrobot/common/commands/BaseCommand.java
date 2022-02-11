package com.iress.toyrobot.common.commands;

import com.iress.toyrobot.common.Position;
import com.iress.toyrobot.common.domain.Robot;
import com.iress.toyrobot.common.domain.Table;

public abstract class BaseCommand {

    private final Position position;

    private final Commands command;

    private Boolean success;

    public BaseCommand(Position position, Commands command) {
        this.position = position;
        this.command = command;
    }

    public void error() {
        success = false;
        System.out.println("Command not executed : " + command.name());
    }

    public void success() {
        success = true;
        System.out.println("Command executed : " + command.name());
    }

    public Commands getCommand() {
        return this.command;
    }

    public Boolean isSuccess() {
        return this.success;
    }
    public Position getPosition() {
        return this.position;
    }

     public abstract void execute(Robot robot, Table table);
}
