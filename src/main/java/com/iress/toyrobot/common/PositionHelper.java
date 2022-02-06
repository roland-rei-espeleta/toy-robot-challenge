package com.iress.toyrobot.common;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class PositionHelper {

    private static final List<Direction> ORDERED_DIRECTIONS = Arrays.stream(Direction.values()).collect(Collectors.toList());

    private PositionHelper() {
        throw new UnsupportedOperationException("Position Helper : Utility class can't be instantiated");
    }

    static List<Direction> getOrderedDirections() {
        return ORDERED_DIRECTIONS;
    }
}
