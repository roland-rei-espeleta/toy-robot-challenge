package com.iress.toyrobot.common.domain;

import com.iress.toyrobot.common.Position;

public class Table {

    private Integer length;
    private Integer width;
    private Integer height;

    public Table(Integer length, Integer width) {
        this.length = length;
        this.width = width;
        this.height = null;
    }

    public Table(Integer length, Integer width, Integer height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public Boolean isValidAction(Position position) {
        return position.getX() < length && position.getY() < width
                && position.getX() >= 0 && position.getY() >= 0;
    }
}
