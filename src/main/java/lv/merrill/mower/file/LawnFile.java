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
            String[] positionLine = mowers.get(i).split(" ");
            Position intialPosition = new Position(new Coordinate(parseInt(positionLine[0]), parseInt(positionLine[1])), Direction.ofCode(positionLine[2]));
            Mower mower = new Mower(intialPosition, lawn);

            String[] instructionsLine = mowers.get(i + 1).split("");
            stream(instructionsLine)
                    .map(Instruction::ofCode)
                    .forEach(mower::execute);

            Position lastPosition = mower.position();
            appender.append(lastPosition).append("\n");
        }

        return appender.toString();
    }

    private Lawn lawn() {
        int lawnX = parseInt(lines.get(0).split(" ")[0]);
        int lawnY = parseInt(lines.get(0).split(" ")[1]);
        Dimension dimension = new Dimension(new Coordinate(lawnX, lawnY));
        return new Lawn(dimension);
    }
}
