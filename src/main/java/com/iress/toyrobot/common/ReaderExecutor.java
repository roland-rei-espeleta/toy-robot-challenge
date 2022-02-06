package com.iress.toyrobot.common;

import com.iress.toyrobot.common.exceptions.ToyRobotException;

public interface ReaderExecutor {

    Reader getReader();

    void execute() throws ToyRobotException;
}
