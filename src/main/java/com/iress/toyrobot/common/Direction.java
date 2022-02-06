package com.iress.toyrobot.common;

public enum Direction {

    NORTH {
        @Override
        public void move(Position position) {
            position.moveNorth();
        }
    },
    EAST {
        @Override
        public void move(Position position) {
            position.moveEast();
        }
    },
    SOUTH {
        @Override
        public void move(Position position) {
            position.moveSouth();
        }
    },
    WEST {
        @Override
        public void move(Position position) {
            position.moveWest();
        }
    };

    public abstract void move(Position position);
}
