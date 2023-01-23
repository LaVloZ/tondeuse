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

    public void execute(String instruction) {
        if("A".equals(instruction)) {
            this.position = lawn.nextPosition(this.position);
            return;
        }

        if ("D".equals(instruction)) {
            position = position.turnRight();
            return;
        }
        position = position.turnLeft();
    }

    public Position position() {
        return position;
    }
}
