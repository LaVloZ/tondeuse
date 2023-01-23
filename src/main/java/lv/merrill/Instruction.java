package lv.merrill;

public interface Instruction {
    Position execute(Position position, Lawn lawn);
}
