package lv.merrill;

public class Mower {

    private int x;
    private int y;
    private String direction;

    public Mower(Position position) {
        this.x = position.x();
        this.y = position.y();
        this.direction = position.direction();
    }

    public Position execute(String instruction) {
        if("N".equals(direction) && "A".equals(instruction)) {
            return new Position(x, y + 1, "N");
        }
        if("E".equals(direction) && "A".equals(instruction)) {
            return new Position(x + 1, y, "E");
        }
        if("S".equals(direction) && "A".equals(instruction)) {
            return new Position(x, y - 1, "S");
        }
        if("W".equals(direction) && "A".equals(instruction)) {
            return new Position(x - 1, y, "W");
        }
        if("N".equals(direction) && "D".equals(instruction)) {
            return new Position(x, y, "E");
        }
        if ("E".equals(direction) && "D".equals(instruction)) {
            return new Position(x, y, "S");
        }
        if ("S".equals(direction) && "D".equals(instruction)) {
            return new Position(x, y, "W");
        }
        if ("W".equals(direction) && "D".equals(instruction)) {
            return new Position(x, y, "N");
        }
        if("E".equals(direction)){
            return new Position(x, y, "N");
        }
        if("S".equals(direction)){
            return new Position(x, y, "E");
        }
        if("W".equals(direction)){
            return new Position(x, y, "S");
        }
        return new Position(x, y, "W");
    }
}
