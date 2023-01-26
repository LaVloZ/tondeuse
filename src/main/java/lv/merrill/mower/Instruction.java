package lv.merrill.mower;

import java.util.Arrays;

public interface Instruction {
    static Instruction ofCode(String code){
        return Arrays.stream(BasicInstruction.values()).filter(instruction -> instruction.hasCode(code)).findFirst().orElse(BasicInstruction.DO_NOTHING);
    }

    Position execute(Position position, Lawn lawn);
}
