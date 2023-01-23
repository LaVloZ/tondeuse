package lv.merrill;

public record Coordinate(int x, int y) {

    public Coordinate plus(Coordinate coordinate) {
        return new Coordinate(this.x + coordinate.x, this.y + coordinate.y);
    }

    public Dimension asDimension() {
        return new Dimension(x + 1, y + 1);
    }
}
