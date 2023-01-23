import lv.merrill.Lawn;
import lv.merrill.Mower;
import lv.merrill.Position;
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
        Mower mower = new Mower(new Position(0, 0, initialDirection));

        mower.execute("G");

        assertThat(mower)
                .extracting(Mower::position)
                .isEqualTo(new Position(0, 0, expectedDirection));
    }

    @ParameterizedTest
    @CsvSource({
            "N, E",
            "E, S",
            "S, W",
            "W, N",
    })
    public void turn_right(String initialDirection, String expectedDirection) {
        Mower mower = new Mower(new Position(0, 0, initialDirection));

        mower.execute( "D");

        assertThat(mower)
                .extracting(Mower::position)
                .isEqualTo(new Position(0, 0, expectedDirection));
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0, N, 0, 1, N",
            "0, 0, E, 1, 0, E",
            "0, 1, S, 0, 0, S",
            "1, 0, W, 0, 0, W",
    })
    public void forward(int initialX, int initialY, String initialDirection, int expectedX, int expectedY, String expectedDirection) {
        Mower mower = new Mower(new Position(initialX, initialY, initialDirection));

        mower.execute( "A");

        assertThat(mower)
                .extracting(Mower::position)
                .isEqualTo(new Position(expectedX, expectedY, expectedDirection));
    }

    @ParameterizedTest
    @CsvSource({
            "0, 4, N",
            "4, 0, E",
            "0, 0, S",
    })
    public void ignore_forward_instruction_on_toward_edge_and_stay_at_the_same_position(int x, int y, String direction) {
        Mower mower = new Mower(new Position(x, y, direction), new Lawn(5, 5));

        mower.execute( "A");

        assertThat(mower)
                .extracting(Mower::position)
                .isEqualTo(new Position(x, y, direction));
    }
}
