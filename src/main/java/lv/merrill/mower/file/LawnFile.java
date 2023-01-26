package lv.merrill.mower.file;

import lv.merrill.mower.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.stream;

public class LawnFile {

    private final List<String> lines;

    public LawnFile(String filePath) throws IOException {
        File target = FileUtils.getFile(filePath);
        lines = FileUtils.readLines(target, StandardCharsets.UTF_8);
    }

    public String result() {
        StringBuilder appender = new StringBuilder();

        Lawn lawn = lawn();

        List<String> mowers = lines.stream().skip(1).toList();
        for (int i = 0; i < mowers.size(); i += 2) {
            Mower mower = mower(lawn, mowers.get(i).split(" "));

            List<BasicInstruction> instructions = instructions(mowers.get(i + 1).split(""));
            instructions.forEach(mower::execute);

            Position lastPosition = mower.position();
            appender.append(lastPosition).append("\n");
        }

        return appender.toString();
    }

    private static List<BasicInstruction> instructions(String[] split) {
        return stream(split)
                .map(BasicInstruction::ofCode).toList();
    }

    private Mower mower(Lawn lawn, String[] mowerLine) {
        Position intialPosition = position(mowerLine);
        return new Mower(intialPosition, lawn);
    }

    private Position position(String[] positionLine) {
        int initialX = parseInt(positionLine[0]);
        int initialY = parseInt(positionLine[1]);
        Direction initialDirection = Direction.ofCode(positionLine[2]);
        Position intialPosition = new Position(new Coordinate(initialX, initialY), initialDirection);
        return intialPosition;
    }

    private Lawn lawn() {
        int lawnX = parseInt(lines.get(0).split(" ")[0]);
        int lawnY = parseInt(lines.get(0).split(" ")[1]);
        Dimension dimension = new Coordinate(lawnX, lawnY).asDimension();
        return new Lawn(dimension);
    }
}
