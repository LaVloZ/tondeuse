package lv.merrill;

public class Mower {

    public static Position execute(int x, int y, String direction, String instructions) {
        if ("N".equals(direction) && "D".equals(instructions)) {
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
