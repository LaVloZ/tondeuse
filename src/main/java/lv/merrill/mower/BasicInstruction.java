package lv.merrill.mower;

import java.util.Arrays;

public enum BasicInstruction implements Instruction {

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

    public static BasicInstruction ofCode(String code){
        return Arrays.stream(values()).filter(instruction -> instruction.code.equals(code)).findFirst().orElse(DO_NOTHING);
    }
}
