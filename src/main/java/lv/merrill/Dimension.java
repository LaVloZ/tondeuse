package lv.merrill;

public record Dimension(int width, int height) {

    public boolean include(Position nextPosition) {
        return nextPosition.coordinate().x() >= 0 && nextPosition.coordinate().y() >= 0 && nextPosition.coordinate().y() < height && nextPosition.coordinate().x() < width;
    }
}