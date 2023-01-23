package lv.merrill;

public class Lawn {
    private final int width;
    private final int height;

    public Lawn(int width, int height) {

        this.width = width;
        this.height = height;
    }

    Position nextPosition(Position position) {
        Position nextPosition = position.forward();
        if (nextPosition.coordinate().y() >= height()){
            return position;
        }
        if (nextPosition.coordinate().x() >= width()){
            return position;
        }
        if (nextPosition.coordinate().y() < 0){
            return position;
        }
        if (nextPosition.coordinate().x() < 0){
            return position;
        }
        return nextPosition;
    }

    public int width() {
        return width;
    }

    public int height() {
        return height;
    }
}
