package lv.merrill;

public class Mower {

    private Position position;

    public Mower(Position position) {
        this.position = position;
    }

    public Position execute(String instruction) {
        if("N".equals(position.direction()) && "A".equals(instruction)) {
            position = new Position(position.x(), position.y() + 1, "N");
            return position;
        }
        if("E".equals(position.direction()) && "A".equals(instruction)) {
            position = new Position(position.x() + 1, position.y(), "E");
            return position;
        }
        if("S".equals(position.direction()) && "A".equals(instruction)) {
            position = new Position(this.position.x(), this.position.y() - 1, "S");
            return position;
        }
        if("W".equals(position.direction()) && "A".equals(instruction)) {
            position = new Position(this.position.x() - 1, this.position.y(), "W");
            return position;
        }
        if("N".equals(position.direction()) && "D".equals(instruction)) {
            position = new Position(this.position.x(), this.position.y(), "E");
            return position;
        }
        if ("E".equals(position.direction()) && "D".equals(instruction)) {
            position = new Position(position.x(), position.y(), "S");
            return position;
        }
        if ("S".equals(position.direction()) && "D".equals(instruction)) {
            position = new Position(this.position.x(), this.position.y(), "W");
            return position;
        }
        if ("W".equals(position.direction()) && "D".equals(instruction)) {
            position = new Position(this.position.x(), this.position.y(), "N");
            return position;
        }
        if("E".equals(position.direction())){
            position = new Position(this.position.x(), this.position.y(), "N");
            return position;
        }
        if("S".equals(position.direction())){
            position = new Position(this.position.x(), this.position.y(), "E");
            return position;
        }
        if("W".equals(position.direction())){
            position = new Position(this.position.x(), this.position.y(), "S");
            return position;
        }
        position = new Position(this.position.x(), this.position.y(), "W");
        return position;
    }

    public boolean isAt(Position position) {
        return this.position.equals(position);
    }
}
