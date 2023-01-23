package lv.merrill;

import java.util.Objects;

public class Position {

    private final Coordinate coordinate;
    private final Direction direction;

    public Position(Coordinate coordinate, Direction direction) {
        this.coordinate = coordinate;
        this.direction = direction;
    }

    public Position(Coordinate coordinate, String direction) {
        this.coordinate = coordinate;
        this.direction = Direction.ofCode(direction);
    }

    public Coordinate coordinate() {
        return coordinate;
    }

    public Direction direction() {
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

    public Position turnRight() {
        return new Position(coordinate, direction.right());
    }
}
