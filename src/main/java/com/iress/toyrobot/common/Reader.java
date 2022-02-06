package com.iress.toyrobot.common;

import java.util.List;

public interface Reader {

    List<RawCommand> read();

    void addCommand(RawCommand command);
}
