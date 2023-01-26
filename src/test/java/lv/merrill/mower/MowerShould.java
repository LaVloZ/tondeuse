package lv.merrill.mower;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lv.merrill.mower.Direction.NORTH;
import static org.assertj.core.api.Assertions.assertThat;

public class MowerShould {

    @ParameterizedTest
    @MethodSource({
            "finish_at_1_3_N_by_starting_at_1_2_N_executing_GAGAGAGAA_on_5_5_lawn",
            "finish_at_5_1_E_by_starting_at_3_3_E_executing_AADAADADDA_on_5_5_lawn",
    })
    public void acceptance_test(int lawnX, int lawnY, int initialX, int initialY, String initialDirection, String instructionsAsString, int lastX, int lastY, String lastDirection) {
        Mower mower = new Mower(new Position(new Coordinate(initialX, initialY), initialDirection), new Lawn(new Coordinate(lawnX, lawnY).asDimension()));
        Stream<Instruction> instruction = Instructions.ofCodes(instructionsAsString);

        instruction.forEach(mower::execute);

        assertThat(mower)
                .extracting(Mower::position)
                .isEqualTo(new Position(new Coordinate(lastX, lastY), lastDirection));
    }

    private static Stream<Arguments> finish_at_1_3_N_by_starting_at_1_2_N_executing_GAGAGAGAA_on_5_5_lawn() {
        return Stream.of(
                Arguments.of(5, 5, 1, 2, "N", "GAGAGAGAA", 1, 3, "N")
        );
    }
    private static Stream<Arguments> finish_at_5_1_E_by_starting_at_3_3_E_executing_AADAADADDA_on_5_5_lawn() {
        return Stream.of(
                Arguments.of(5, 5, 3, 3, "E", "AADAADADDA", 5, 1, "E")
        );
    }

    @ParameterizedTest
    @CsvSource({
            "N, W",
            "W, S",
            "S, E",
            "E, N",
    })
    public void turn_left(String initialDirection, String expectedDirection) {
        Mower mower = new Mower(new Position(new Coordinate(0, 0), initialDirection), new Lawn(new Dimension(5, 5)));

        mower.execute(Instruction.ofCode("G"));

        assertThat(mower)
                .extracting(Mower::position)
                .isEqualTo(new Position(new Coordinate(0, 0), expectedDirection));
    }

    @ParameterizedTest
    @CsvSource({
            "N, E",
            "E, S",
            "S, W",
            "W, N",
    })
    public void turn_right(String initialDirection, String expectedDirection) {
        Mower mower = new Mower(new Position(new Coordinate(0, 0), initialDirection), new Lawn(new Dimension(5, 5)));

        mower.execute(Instruction.ofCode("D"));

        assertThat(mower)
                .extracting(Mower::position)
                .isEqualTo(new Position(new Coordinate(0, 0), expectedDirection));
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0, N, 0, 1, N",
            "0, 0, E, 1, 0, E",
            "0, 1, S, 0, 0, S",
            "1, 0, W, 0, 0, W",
    })
    public void forward(int initialX, int initialY, String initialDirection, int expectedX, int expectedY, String expectedDirection) {
        Mower mower = new Mower(new Position(new Coordinate(initialX, initialY), initialDirection), new Lawn(new Dimension(5, 5)));

        mower.execute(Instruction.ofCode("A"));

        assertThat(mower)
                .extracting(Mower::position)
                .isEqualTo(new Position(new Coordinate(expectedX, expectedY), expectedDirection));
    }

    @ParameterizedTest
    @CsvSource({
            "0, 4, N",
            "4, 0, E",
            "0, 0, S",
            "0, 0, W",
    })
    public void ignore_forward_instruction_on_toward_edge_and_stay_at_the_same_position(int x, int y, String direction) {
        Mower mower = new Mower(new Position(new Coordinate(x, y), direction), new Lawn((new Coordinate(4, 4).asDimension())));

        mower.execute(Instruction.ofCode("A"));

        assertThat(mower)
                .extracting(Mower::position)
                .isEqualTo(new Position(new Coordinate(x, y), direction));
    }

    @Test
    public void ignore_unknown_instruction_and_stay_at_the_actual_position() {
        Mower mower = new Mower(new Position(new Coordinate(0, 0), NORTH), new Lawn(new Coordinate(4, 4).asDimension()));

        mower.execute(Instruction.ofCode("X"));

        assertThat(mower)
                .extracting(Mower::position)
                .isEqualTo(new Position(new Coordinate(0, 0), NORTH));
    }
}
