package lv.merrill;

public enum Direction {
    NORTH("N") {
        @Override
        public Direction left() {
            return null;
        }

        @Override
        public Direction right() {
            return null;
        }
    },
    EAST("E") {
        @Override
        public Direction left() {
            return null;
        }

        @Override
        public Direction right() {
            return null;
        }
    },
    SOUTH("S") {
        @Override
        public Direction left() {
            return null;
        }

        @Override
        public Direction right() {
            return null;
        }
    },
    WEST("W") {
        @Override
        public Direction left() {
            return null;
        }

        @Override
        public Direction right() {
            return null;
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
}