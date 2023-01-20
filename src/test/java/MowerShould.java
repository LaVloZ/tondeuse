import lv.merrill.Mower;
import lv.merrill.Position;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

        Position position = mower.execute("G");

        Assertions.assertThat(position).isEqualTo(new Position(0, 0, expectedDirection));
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

        Position position = mower.execute( "D");

        Assertions.assertThat(position).isEqualTo(new Position(0, 0, expectedDirection));
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

        Position position = mower.execute( "A");

        Assertions.assertThat(position).isEqualTo(new Position(expectedX, expectedY, expectedDirection));
    }
}
