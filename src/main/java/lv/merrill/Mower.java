package lv.merrill;

public class Mower {

    private int x;
    private int y;
    private String direction;

    public Mower(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Position execute(String instructions) {
        if("N".equals(direction) && "A".equals(instructions)) {
            return new Position(x + 1, y, "N");
        }
        if("E".equals(direction) && "A".equals(instructions)) {
            return new Position(x, y + 1, "E");
        }
        if("N".equals(direction) && "D".equals(instructions)) {
            return new Position(x, y, "E");
        }
        if ("E".equals(direction) && "D".equals(instructions)) {
            return new Position(x, y, "S");
        }
        if ("S".equals(direction) && "D".equals(instructions)) {
            return new Position(x, y, "W");
        }
        if ("W".equals(direction) && "D".equals(instructions)) {
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
