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
            nextPosition(this);
            return;
        }

        if ("D".equals(instruction)) {
            position = position.turnRight();
            return;
        }
        position = position.turnLeft();
    }

    private static void nextPosition(Mower mower) {
        Position position = new Position(mower.position.coordinate().plus(mower.position.direction().step()), mower.position.direction());
        if (position.coordinate().y() >= mower.lawn.height()){
            return;
        }
        if (position.coordinate().x() >= mower.lawn.width()){
            return;
        }
        if (position.coordinate().y() < 0){
            return;
        }
        if (position.coordinate().x() < 0){
            return;
        }
        mower.position = position;
    }

    public Position position() {
        return position;
    }
}
