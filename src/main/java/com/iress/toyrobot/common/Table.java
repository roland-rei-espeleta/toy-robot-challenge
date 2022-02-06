package com.iress.toyrobot.common;

public class Table {

    private Integer length;
    private Integer width;

    public Table(Integer length, Integer width) {
        this.length = length;
        this.width = width;
    }

    public Boolean isValidAction(Position position) {
        return position.getX() < length && position.getY() < width
                && position.getX() >= 0 && position.getY() >= 0;
    }
}
