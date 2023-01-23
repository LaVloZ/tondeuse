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
        if("N".equals(position.direction()) && "A".equals(instruction)) {
            Position position = new Position(new Coordinate(this.position.coordinate().x(), this.position.coordinate().y() + 1), "N");
            if (position.coordinate().y() >= lawn.height()){
                return;
            }
            this.position = position;
            return;
        }
        if("E".equals(position.direction()) && "A".equals(instruction)) {
            Position position = new Position(new Coordinate(this.position.coordinate().x() + 1, this.position.coordinate().y()), "E");
            if (position.coordinate().x() >= lawn.width()){
                return;
            }
            this.position = position;
            return;
        }
        if("S".equals(position.direction()) && "A".equals(instruction)) {
            Position position = new Position(new Coordinate(this.position.coordinate().x(), this.position.coordinate().y() - 1), "S");
            if (position.coordinate().y() < 0){
                return;
            }
            this.position = position;
            return;
        }
        if("W".equals(position.direction()) && "A".equals(instruction)) {
            Position position = new Position(new Coordinate(this.position.coordinate().x() - 1, this.position.coordinate().y()), "W");
            if (position.coordinate().x() < 0){
                return;
            }
            this.position = position;
            return;
        }
        if("N".equals(position.direction()) && "D".equals(instruction)) {
            position = new Position(new Coordinate(this.position.coordinate().x(), this.position.coordinate().y()), "E");
            return;
        }
        if ("E".equals(position.direction()) && "D".equals(instruction)) {
            position = new Position(new Coordinate(position.coordinate().x(), position.coordinate().y()), "S");
            return;
        }
        if ("S".equals(position.direction()) && "D".equals(instruction)) {
            position = new Position(new Coordinate(this.position.coordinate().x(), this.position.coordinate().y()), "W");
            return;
        }
        if ("W".equals(position.direction()) && "D".equals(instruction)) {
            position = new Position(new Coordinate(this.position.coordinate().x(), this.position.coordinate().y()), "N");
            return;
        }
        if("E".equals(position.direction())){
            position = new Position(new Coordinate(this.position.coordinate().x(), this.position.coordinate().y()), "N");
            return;
        }
        if("S".equals(position.direction())){
            position = new Position(new Coordinate(this.position.coordinate().x(), this.position.coordinate().y()), "E");
            return;
        }
        if("W".equals(position.direction())){
            position = new Position(new Coordinate(this.position.coordinate().x(), this.position.coordinate().y()), "S");
            return;
        }
        position = new Position(new Coordinate(this.position.coordinate().x(), this.position.coordinate().y()), "W");
    }

    public Position position() {
        return position;
    }
}
