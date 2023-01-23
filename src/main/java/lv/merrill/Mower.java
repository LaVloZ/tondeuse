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
            Position position = new Position(this.position.x(), this.position.y() + 1, "N");
            if (position.y() >= lawn.height()){
                return;
            }
            this.position = position;
            return;
        }
        if("E".equals(position.direction()) && "A".equals(instruction)) {
            Position position = new Position(this.position.x() + 1, this.position.y(), "E");
            if (position.x() >= lawn.width()){
                return;
            }
            this.position = position;
            return;
        }
        if("S".equals(position.direction()) && "A".equals(instruction)) {
            Position position = new Position(this.position.x(), this.position.y() - 1, "S");
            if (position.y() < 0){
                return;
            }
            this.position = position;
            return;
        }
        if("W".equals(position.direction()) && "A".equals(instruction)) {
            Position position = new Position(this.position.x() - 1, this.position.y(), "W");
            if (position.x() < 0){
                return;
            }
            this.position = position;
            return;
        }
        if("N".equals(position.direction()) && "D".equals(instruction)) {
            position = new Position(this.position.x(), this.position.y(), "E");
            return;
        }
        if ("E".equals(position.direction()) && "D".equals(instruction)) {
            position = new Position(position.x(), position.y(), "S");
            return;
        }
        if ("S".equals(position.direction()) && "D".equals(instruction)) {
            position = new Position(this.position.x(), this.position.y(), "W");
            return;
        }
        if ("W".equals(position.direction()) && "D".equals(instruction)) {
            position = new Position(this.position.x(), this.position.y(), "N");
            return;
        }
        if("E".equals(position.direction())){
            position = new Position(this.position.x(), this.position.y(), "N");
            return;
        }
        if("S".equals(position.direction())){
            position = new Position(this.position.x(), this.position.y(), "E");
            return;
        }
        if("W".equals(position.direction())){
            position = new Position(this.position.x(), this.position.y(), "S");
            return;
        }
        position = new Position(this.position.x(), this.position.y(), "W");
    }

    public Position position() {
        return position;
    }
}
