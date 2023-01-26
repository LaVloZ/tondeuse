package lv.merrill.mower;

import java.util.Arrays;

public enum Direction {
    NORTH("N") {
        @Override
        public Coordinate step() {
            return new Coordinate(0, 1);
        }
    },
    EAST("E") {

        @Override
        public Coordinate step() {
            return new Coordinate(1, 0);
        }
    },
    SOUTH("S") {
        @Override
        public Coordinate step() {
            return new Coordinate(0, -1);
        }
    },
    WEST("W") {
        @Override
        public Coordinate step() {
            return new Coordinate(-1, 0);
        }
    };

    Direction(String code) {
        this.code = code;
    }

    private final String code;

    public Direction left() {
        return turnTo(-1);
    }
    public Direction right() {
        return turnTo(1);
    }

    private Direction turnTo(int variation) {
        return values()[(values().length + this.ordinal() + variation) % values().length];
    }

    public abstract Coordinate step();

    @Override
    public String toString() {
        return code;
    }

    public static Direction ofCode(String code) {
        return Arrays.stream(values())
                .filter(direction -> direction.code.equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}