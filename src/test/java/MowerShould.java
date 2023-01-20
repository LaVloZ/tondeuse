import lv.merrill.Mower;
import lv.merrill.Position;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.BOOLEAN;

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
                .extracting(m -> m.isAt(new Position(0, 0, expectedDirection)), BOOLEAN)
                .isTrue();
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
                .extracting(m -> m.isAt(new Position(0, 0, expectedDirection)), BOOLEAN)
                .isTrue();
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
                .extracting(m -> m.isAt(new Position(expectedX, expectedY, expectedDirection)), BOOLEAN)
                .isTrue();
    }
}
