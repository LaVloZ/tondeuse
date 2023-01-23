package lv.merrill;

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
    };

    private String code;

    Instruction(String code) {
        this.code = code;
    }

    public abstract Position execute(Position position, Lawn lawn);

    public static Instruction ofCode(String code){
        if("A".equals(code)) {
            return FORWARD;
        }

        if ("D".equals(code)) {
            return RIGHT;
        }
        return LEFT;
    }
}
