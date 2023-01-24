package lv.merrill.mower;

import java.util.Arrays;

public enum Instruction {

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

    Instruction(String code) {
        this.code = code;
    }

    public abstract Position execute(Position position, Lawn lawn);

    public static Instruction ofCode(String code){
        return Arrays.stream(values()).filter(instruction -> instruction.code.equals(code)).findFirst().orElse(DO_NOTHING);
    }
}
