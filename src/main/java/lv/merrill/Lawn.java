package lv.merrill;

public class Lawn {
    private Dimension dimension;

    public Lawn(Dimension dimension) {

        this.dimension = dimension;
    }

    Position nextPosition(Position position) {
        Position nextPosition = position.forward();
        if (nextPosition.coordinate().y() >= dimension.height()){
            return position;
        }
        if (nextPosition.coordinate().x() >= dimension.width()){
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
}
