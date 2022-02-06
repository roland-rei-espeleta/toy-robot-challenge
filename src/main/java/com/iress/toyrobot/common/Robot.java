package com.iress.toyrobot.common;

public class Robot {

    private Position position;

    public Robot() {
        position = null;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position getPosition() {
        return this.position;
    }

    public String report() {
        return this.position.toString();
    }

    public Boolean isPlaced() {
        return position != null;
    }
}
