package lv.merrill;

public class Mower {

    private Position position;
    private final Lawn lawn;

    public Mower(Position initialPosition, Lawn lawn) {
        this.position = initialPosition;
        this.lawn = lawn;
    }
    public void execute(Instruction instruction) {
        position = instruction.execute(position, lawn);
    }

    public Position position() {
        return position;
    }
}
