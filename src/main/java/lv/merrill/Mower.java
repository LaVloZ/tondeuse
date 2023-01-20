package lv.merrill;

public class Mower {

    public static Position execute(int i, int y, String direction, String instructions) {
        if ("N".equals(direction) && "D".equals(instructions)) {
            return new Position(i, y, "E");
        }
        if("E".equals(direction)){
            return new Position(i, y, "N");
        }
        if("S".equals(direction)){
            return new Position(i, y, "E");
        }
        if("W".equals(direction)){
            return new Position(i, y, "S");
        }
        return new Position(i, y, "W");
    }
}
