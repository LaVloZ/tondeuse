package lv.merrill;

public class Instruction1 implements Instruction {

    private final String instruction;

    public Instruction1(String instruction) {
        this.instruction = instruction;
    }

    @Override
    public Position execute(Position position, Lawn lawn) {
        if("A".equals(instruction)) {
            return lawn.nextPosition(position);
        }

        if ("D".equals(instruction)) {
            return position.turnRight();
        }
        return position.turnLeft();
    }
}