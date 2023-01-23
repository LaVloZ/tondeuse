package lv.merrill;

public record Instruction1(String instruction) implements Instruction {
    @Override
    public Position execute(Position position, Lawn lawn) {
        if("A".equals(instruction())) {
            return lawn.nextPosition(position);
        }

        if ("D".equals(instruction())) {
            return position.turnRight();
        }
        return position.turnLeft();
    }
}