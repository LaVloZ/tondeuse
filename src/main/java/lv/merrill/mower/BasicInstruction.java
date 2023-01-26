package lv.merrill.mower;

enum BasicInstruction implements Instruction {

    FORWARD("A"){
        @Override
        public Position execute(Position position, Lawn lawn) {
            return lawn.nextPosition(position);
        }
    },
    LEFT("G") {
        @Override
        public Position execute(Position position, Lawn lawn) {
            return position.turnLeft();
        }
    },
    RIGHT("D") {
        @Override
        public Position execute(Position position, Lawn lawn) {
            return position.turnRight();
        }
    },
    DO_NOTHING("") {
        @Override
        public Position execute(Position position, Lawn lawn) {
            return position;
        }
    };

    private final String code;

    BasicInstruction(String code) {
        this.code = code;
    }

    public boolean hasCode(String code) {
        return this.code.equals(code);
    }
}
