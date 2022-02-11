package com.iress.toyrobot.file;

import com.iress.toyrobot.common.RawCommand;
import com.iress.toyrobot.common.CommandReader;
import java.util.ArrayList;
import java.util.List;

public class FileCommandReader implements CommandReader {

    private List<RawCommand> commands;

    FileCommandReader() {
        commands = new ArrayList<>();
    }

    @Override
    public List<RawCommand> readCommands() {
        return this.commands;
    }

    @Override
    public void addCommand(RawCommand command) {
        commands.add(command);
    }
}
