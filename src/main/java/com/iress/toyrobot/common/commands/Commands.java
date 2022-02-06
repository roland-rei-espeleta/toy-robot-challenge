package com.iress.toyrobot.common.commands;

import com.iress.toyrobot.common.Direction;
import com.iress.toyrobot.common.Position;
import com.iress.toyrobot.common.RawCommand;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Commands {

    PLACE {
        @Override
        public BaseCommand getCommand(RawCommand rawCommand) {
            String[] commands = rawCommand.getCommand().split(" ")[1].split(",");
            return new PlaceCommand(new Position(commands[0], commands[1], commands[2]), PLACE);
        }

        @Override
        public Pattern getPattern() {
            return Pattern.compile("^PLACE\\s+\\d+\\s*,\\s*\\d+\\s*,\\s*(NORTH|SOUTH|EAST|WEST)$");
        }
    },
    LEFT {
        @Override
        public BaseCommand getCommand(RawCommand rawCommand) {
            return new LeftCommand(LEFT);
        }
    },
    RIGHT {
        @Override
        public BaseCommand getCommand(RawCommand rawCommand) {
            return new RightCommand(RIGHT);
        }
    },
    REPORT {
        @Override
        public BaseCommand getCommand(RawCommand rawCommand) {
            return new ReportCommand(REPORT);
        }
    },
    MOVE {
        @Override
        public BaseCommand getCommand(RawCommand rawCommand) {
            return new MoveCommand(MOVE);
        }
    },
    ERROR {
        @Override
        public BaseCommand getCommand(RawCommand rawCommand) {
            return new CommandError(rawCommand, ERROR);
        }

        @Override
        public Boolean valid() {
            return false;
        }
    };

    public abstract BaseCommand getCommand(RawCommand rawCommand);

    public Boolean valid() {
        return true;
    }

    public Pattern getPattern() {
        String pattern = "^" + name() + "$";
        return Pattern.compile(pattern);
    };

    public Boolean isMatched(RawCommand rawCommand) {
        Matcher matcher = getPattern().matcher(rawCommand.getCommand());
        return matcher.matches();
    }
}
