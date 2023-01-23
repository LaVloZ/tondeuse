package lv.merrill;

public class Mower {

    private Position position;
    private final Lawn lawn;

    public Mower(Position initialPosition) {
        this.position = initialPosition;
        this.lawn = new Lawn(5, 5);
    }

    public Mower(Position initialPosition, Lawn lawn) {
        this.position = initialPosition;
        this.lawn = lawn;
    }
    public void execute(Instruction instruction) {
        if("A".equals(instruction.instruction())) {
            this.position = lawn.nextPosition(this.position);
            return;
        }

        if ("D".equals(instruction.instruction())) {
            position = position.turnRight();
            return;
        }
        position = position.turnLeft();
    }

    public Position position() {
        return position;
    }
}
