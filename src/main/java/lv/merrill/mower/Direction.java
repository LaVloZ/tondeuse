package lv.merrill.mower;

import java.util.Arrays;

public enum Direction {
    NORTH("N") {
        @Override
        public Direction left() {
            return WEST;
        }

        @Override
        public Coordinate step() {
            return new Coordinate(0, 1);
        }
    },
    EAST("E") {
        @Override
        public Direction left() {
            return NORTH;
        }

        @Override
        public Coordinate step() {
            return new Coordinate(1, 0);
        }
    },
    SOUTH("S") {
        @Override
        public Direction left() {
            return EAST;
        }

        @Override
        public Coordinate step() {
            return new Coordinate(0, -1);
        }
    },
    WEST("W") {
        @Override
        public Direction left() {
            return SOUTH;
        }

        @Override
        public Direction right() {
            return NORTH;
        }

        @Override
        public Coordinate step() {
            return new Coordinate(-1, 0);
        }
    };

    Direction(String code) {
        this.code = code;
    }

    private final String code;

    public abstract Direction left();
    public Direction right() {
        return values()[this.ordinal() + 1];
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