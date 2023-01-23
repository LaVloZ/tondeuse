package lv.merrill;

public class Lawn {
    private final Dimension dimension;

    public Lawn(Dimension dimension) {

        this.dimension = dimension;
    }

    Position nextPosition(Position position) {
        Position nextPosition = position.forward();
        if (dimension.isInside(nextPosition)){
            return position;
        }
        return nextPosition;
    }

}
