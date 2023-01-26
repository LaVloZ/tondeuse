package lv.merrill.mower;

public interface Instruction {
    Position execute(Position position, Lawn lawn);
}
