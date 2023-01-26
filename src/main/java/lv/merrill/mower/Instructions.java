package lv.merrill.mower;

import java.util.stream.Stream;

public class Instructions {
    public static Stream<Instruction> ofCodes(String instructionsAsString) {
        return instructionsAsString.chars()
                .mapToObj(value -> (char) value)
                .map(String::valueOf)
                .map(Instruction::ofCode);
    }
}
