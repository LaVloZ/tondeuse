package lv.merrill;

public class Lawn {
    private final int width;
    private final int height;

    public Lawn(int width, int height) {

        this.width = width;
        this.height = height;
    }

    Position nextPosition(Position position1) {
        Position position = new Position(position1.coordinate().plus(position1.direction().step()), position1.direction());
        if (position.coordinate().y() >= height()){
            return null;
        }
        if (position.coordinate().x() >= width()){
            return null;
        }
        if (position.coordinate().y() < 0){
            return null;
        }
        if (position.coordinate().x() < 0){
            return null;
        }
        return position;
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }
}
