package com.iress.toyrobot.common.commands;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.iress.toyrobot.common.RawCommand;

import static com.iress.toyrobot.common.commands.Commands.ERROR;

public class CommandParser {

    private static final List<Commands> COMMANDS = Arrays.stream(Commands.values()).collect(Collectors.toList());

    private CommandParser() {
        throw new UnsupportedOperationException("Command Parser: Utility class!!");
    }

    public static BaseCommand parse(RawCommand rawCommand) {

        BaseCommand baseCommand;

        baseCommand = COMMANDS.stream().
                filter(commands -> commands.valid() && commands.isMatched(rawCommand))
                .findFirst()
                .map(command -> command.getCommand(rawCommand))
                .orElseGet(() -> ERROR.getCommand(rawCommand));

        return baseCommand;
    }
}
