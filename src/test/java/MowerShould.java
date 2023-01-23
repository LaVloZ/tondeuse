import lv.merrill.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MowerShould {

    @ParameterizedTest
    @CsvSource({
            "N, W",
            "W, S",
            "S, E",
            "E, N",
    })
    public void turn_left(String initialDirection, String expectedDirection) {
        Mower mower = new Mower(new Position(new Coordinate(0, 0), initialDirection));

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
        Mower mower = new Mower(new Position(new Coordinate(0, 0), initialDirection));

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
        Mower mower = new Mower(new Position(new Coordinate(initialX, initialY), initialDirection));

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
        Mower mower = new Mower(new Position(new Coordinate(x, y), direction), new Lawn(5, 5));

        mower.execute(Instruction.ofCode("A"));

        assertThat(mower)
                .extracting(Mower::position)
                .isEqualTo(new Position(new Coordinate(x, y), direction));
    }
}
