package lv.merrill.mower;

public class Dimension {

    private final int width;
    private final int height;

    public Dimension(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public boolean include(Dimension dimension) {
        return dimension.width >= 1
                && dimension.height >= 1
                && dimension.height <= height
                && dimension.width <= width;
    }
}