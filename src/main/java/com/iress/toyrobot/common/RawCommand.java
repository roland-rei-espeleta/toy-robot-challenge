package com.iress.toyrobot.common;

public class RawCommand {

    private String command;

    public RawCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return this.command;
    }

    @Override
    public String toString() {
        return "RawCommand{" +
                "command='" + command + '\'' +
                '}';
    }
}
