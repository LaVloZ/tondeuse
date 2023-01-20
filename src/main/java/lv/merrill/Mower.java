package lv.merrill;

public class Mower {

    private Position position;

    public Mower(Position position) {
        this.position = position;
    }

    public Position execute(String instruction) {
        if("N".equals(position.direction()) && "A".equals(instruction)) {
            return new Position(position.x(), position.y() + 1, "N");
        }
        if("E".equals(position.direction()) && "A".equals(instruction)) {
            return new Position(position.x() + 1, position.y(), "E");
        }
        if("S".equals(position.direction()) && "A".equals(instruction)) {
            return new Position(position.x(), position.y() - 1, "S");
        }
        if("W".equals(position.direction()) && "A".equals(instruction)) {
            return new Position(position.x() - 1, position.y(), "W");
        }
        if("N".equals(position.direction()) && "D".equals(instruction)) {
            return new Position(position.x(), position.y(), "E");
        }
        if ("E".equals(position.direction()) && "D".equals(instruction)) {
            return new Position(position.x(), position.y(), "S");
        }
        if ("S".equals(position.direction()) && "D".equals(instruction)) {
            return new Position(position.x(), position.y(), "W");
        }
        if ("W".equals(position.direction()) && "D".equals(instruction)) {
            return new Position(position.x(), position.y(), "N");
        }
        if("E".equals(position.direction())){
            return new Position(position.x(), position.y(), "N");
        }
        if("S".equals(position.direction())){
            return new Position(position.x(), position.y(), "E");
        }
        if("W".equals(position.direction())){
            return new Position(position.x(), position.y(), "S");
        }
        return new Position(position.x(), position.y(), "W");
    }
}
