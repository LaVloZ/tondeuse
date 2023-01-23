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
        if(Direction.NORTH.equals(position.direction()) && "A".equals(instruction)) {
            Position position = new Position(this.position.coordinate().plus(Direction.NORTH.step()), Direction.NORTH);
            if (position.coordinate().y() >= lawn.height()){
                return;
            }
            this.position = position;
            return;
        }
        if(Direction.EAST.equals(position.direction()) && "A".equals(instruction)) {
            Position position = new Position(this.position.coordinate().plus(Direction.EAST.step()), Direction.EAST);
            if (position.coordinate().x() >= lawn.width()){
                return;
            }
            this.position = position;
            return;
        }
        if(Direction.SOUTH.equals(position.direction()) && "A".equals(instruction)) {
            Position position = new Position(this.position.coordinate().plus(Direction.SOUTH.step()), Direction.SOUTH);
            if (position.coordinate().y() < 0){
                return;
            }
            this.position = position;
            return;
        }
        if(Direction.WEST.equals(position.direction()) && "A".equals(instruction)) {
            Position position = new Position(this.position.coordinate().plus(Direction.WEST.step()), Direction.WEST);
            if (position.coordinate().x() < 0){
                return;
            }
            this.position = position;
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
