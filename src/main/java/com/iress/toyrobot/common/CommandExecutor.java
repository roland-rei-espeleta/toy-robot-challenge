package com.iress.toyrobot.common;

import java.util.List;
import java.util.stream.Collectors;

import com.iress.toyrobot.common.commands.BaseCommand;
import com.iress.toyrobot.common.commands.CommandParser;

public class CommandExecutor {

    private final Robot robot;

    private final Table table;

    private final List<RawCommand> commands;

    private List<BaseCommand> baseCommands;

    public CommandExecutor(List<RawCommand> commands) {
        this.commands = commands;
        this.robot = new Robot();
        this.table = new Table(5, 5);
        this.baseCommands = commands.stream().map(this::parse).collect(Collectors.toList());
    }

    private BaseCommand parse(RawCommand rawCommand) {
        return CommandParser.parse(rawCommand);
    }

    public void execute() {
        baseCommands.stream().forEach(baseCommand -> {
            baseCommand.execute(robot, table);
        });
    }

    public Robot getRobot() {
        return this.robot;
    }

    public List<BaseCommand> getBaseCommands() {
        return this.baseCommands;
    }

}
