package com.iress.toyrobot.common;

import java.util.List;

public interface CommandReader {

    List<RawCommand> readCommands();

    void addCommand(RawCommand command);
}
