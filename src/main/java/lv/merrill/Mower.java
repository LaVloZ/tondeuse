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
            Position position = nextPosition(this.position, lawn);
            if (position == null) return;
            this.position = position;
            return;
        }

        if ("D".equals(instruction)) {
            position = position.turnRight();
            return;
        }
        position = position.turnLeft();
    }

    private static Position nextPosition(Position position1, Lawn lawn) {
        Position position = new Position(position1.coordinate().plus(position1.direction().step()), position1.direction());
        if (position.coordinate().y() >= lawn.height()){
            return null;
        }
        if (position.coordinate().x() >= lawn.width()){
            return null;
        }
        if (position.coordinate().y() < 0){
            return null;
        }
        if (position.coordinate().x() < 0){
            return null;
        }
        return position;
    }

    public Position position() {
        return position;
    }
}
