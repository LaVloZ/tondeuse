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
            Position position = new Position(new Coordinate(this.position.coordinate().x(), this.position.coordinate().y() + 1), Direction.NORTH);
            if (position.coordinate().y() >= lawn.height()){
                return;
            }
            this.position = position;
            return;
        }
        if(Direction.EAST.equals(position.direction()) && "A".equals(instruction)) {
            Position position = new Position(new Coordinate(this.position.coordinate().x() + 1, this.position.coordinate().y()), Direction.EAST);
            if (position.coordinate().x() >= lawn.width()){
                return;
            }
            this.position = position;
            return;
        }
        if(Direction.SOUTH.equals(position.direction()) && "A".equals(instruction)) {
            Position position = new Position(new Coordinate(this.position.coordinate().x(), this.position.coordinate().y() - 1), Direction.SOUTH);
            if (position.coordinate().y() < 0){
                return;
            }
            this.position = position;
            return;
        }
        if(Direction.WEST.equals(position.direction()) && "A".equals(instruction)) {
            Position position = new Position(new Coordinate(this.position.coordinate().x() - 1, this.position.coordinate().y()), Direction.WEST);
            if (position.coordinate().x() < 0){
                return;
            }
            this.position = position;
            return;
        }
        if ("D".equals(instruction)) {
            position = new Position(new Coordinate(this.position.coordinate().x(), this.position.coordinate().y()), position.direction().right());
            return;
        }
        if(Direction.EAST.equals(position.direction())){
            position = new Position(new Coordinate(this.position.coordinate().x(), this.position.coordinate().y()), Direction.NORTH);
            return;
        }
        if(Direction.SOUTH.equals(position.direction())){
            position = new Position(new Coordinate(this.position.coordinate().x(), this.position.coordinate().y()), Direction.EAST);
            return;
        }
        if(Direction.WEST.equals(position.direction())){
            position = new Position(new Coordinate(this.position.coordinate().x(), this.position.coordinate().y()), Direction.SOUTH);
            return;
        }
        position = new Position(new Coordinate(this.position.coordinate().x(), this.position.coordinate().y()), Direction.WEST);
    }

    public Position position() {
        return position;
    }
}
