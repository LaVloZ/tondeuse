package lv.merrill;

import java.util.Arrays;

public enum Direction {
    NORTH("N") {
        @Override
        public Direction left() {
            return null;
        }

        @Override
        public Direction right() {
            return Direction.EAST;
        }
    },
    EAST("E") {
        @Override
        public Direction left() {
            return NORTH;
        }

        @Override
        public Direction right() {
            return SOUTH;
        }
    },
    SOUTH("S") {
        @Override
        public Direction left() {
            return EAST;
        }

        @Override
        public Direction right() {
            return WEST;
        }
    },
    WEST("W") {
        @Override
        public Direction left() {
            return null;
        }

        @Override
        public Direction right() {
            return NORTH;
        }
    };

    Direction(String code) {
        this.code = code;
    }

    private String code;

    public abstract Direction left();
    public abstract Direction right();

    @Override
    public String toString() {
        return code;
    }

    public static Direction ofCode(String code) {
        return Arrays.stream(Direction.values()).filter(direction -> direction.code.equals(code)).findFirst().orElseThrow(IllegalArgumentException::new);
    }
}