package lv.merrill.mower;

import java.util.List;

public class Instructions implements Instruction {

    private List<Instruction> instructions;

    public Instructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    @Override
    public Position execute(Position position, Lawn lawn) {
        for (Instruction i : instructions) {
            position = i.execute(position, lawn);
        }
        return position;
    }

    public static Instruction ofCodes(String instructionsAsString) {
        return new Instructions(instructionsAsString.chars()
                .mapToObj(value -> (char) value)
                .map(String::valueOf)
                .map(Instruction::ofCode)
                .toList());
    }
}
