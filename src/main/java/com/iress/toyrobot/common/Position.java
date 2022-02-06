package com.iress.toyrobot.common;

import java.util.List;
import java.util.StringJoiner;

public class Position {

    private Integer x;
    private Integer y;
    private Direction direction;

    /**
     * Sample Position ( 0, 1, NORTH )
     * @param x - x coordinate.
     * @param y - y coordinate
     * @param direction - position facing
     */
    public Position(Integer x, Integer y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Position(String x, String y, String direction) {
        this.x = Integer.valueOf(x);
        this.y = Integer.valueOf(y);
        this.direction = Direction.valueOf(direction);
    }

    public Integer getX() {
        return this.x;
    }

    public Integer getY() {
        return this.y;
    }

    public Direction getDirection() {
        return this.direction;
    }

    /**
     * Update the direction of the current position based on the current direction ( LEFT )
     * @return Position
     */
    public Position turnLeft() {
        List<Direction> directions = PositionHelper.getOrderedDirections();
        this.direction = directions.get(((directions.indexOf(direction) - 1) + directions.size()) % directions.size());
        return this;
    }

    /**
     * Update the direction of the current position based on the current direction ( RIGHT )
     * @return Position
     */
    public Position turnRight() {
        List<Direction> directions = PositionHelper.getOrderedDirections();
        this.direction = directions.get(((directions.indexOf(direction) + 1) + directions.size()) % directions.size());
        return this;
    }

    public void moveNorth() {
        this.y = this.y + 1;
    }

    public void moveEast() {
        this.x = x + 1;
    }

    public void moveSouth() {
        this.y = this.y - 1;
    }

    public void moveWest() {
        this.x = x -1;
    }

    @Override
    public String toString() {
        StringJoiner sb = new StringJoiner(",");
            sb.add(x.toString());
            sb.add(y.toString());
            sb.add(direction.toString());
        return sb.toString();
    }
}
