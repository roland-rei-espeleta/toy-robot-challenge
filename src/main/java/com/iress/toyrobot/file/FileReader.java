package com.iress.toyrobot.file;

import com.iress.toyrobot.common.RawCommand;
import com.iress.toyrobot.common.Reader;
import java.util.ArrayList;
import java.util.List;

public class FileReader implements Reader {

    private List<RawCommand> commands;

    FileReader() {
        commands = new ArrayList<>();
    }

    @Override
    public List<RawCommand> read() {
        return this.commands;
    }

    @Override
    public void addCommand(RawCommand command) {
        commands.add(command);
    }
}
