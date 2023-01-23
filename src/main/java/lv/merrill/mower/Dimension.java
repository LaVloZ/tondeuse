package lv.merrill.mower;

public record Dimension(int width, int height) {

    public boolean include(Dimension dimension) {
        return dimension.width >= 1
                && dimension.height >= 1
                && dimension.height <= height
                && dimension.width <= width;
    }
}