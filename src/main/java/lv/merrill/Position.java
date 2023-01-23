package lv.merrill;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Position {

    private static Map<String, Direction> directions = new HashMap<>();
    static {
        directions.put("N", Direction.NORTH);
        directions.put("E", Direction.EAST);
        directions.put("S", Direction.SOUTH);
        directions.put("W", Direction.WEST);
    }
    private Coordinate coordinate;
    private String direction;

    public Position(Coordinate coordinate, Direction direction) {
        this.coordinate = coordinate;
    }

    public Position(Coordinate coordinate, String direction) {
        this.coordinate = coordinate;
        this.direction = direction;
    }

    public Coordinate coordinate() {
        return coordinate;
    }

    public String direction() {
        return direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return coordinate.equals(position.coordinate) && direction.equals(position.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinate, direction);
    }

    @Override
    public String toString() {
        return "Position{" +
                "coordinate=" + coordinate +
                ", direction=" + direction +
                '}';
    }
}
