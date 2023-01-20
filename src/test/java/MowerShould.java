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
        Position position = Mower.execute(0, 0, initialDirection, "G");

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
        Position position = Mower.execute(0, 0, initialDirection, "D");

        Assertions.assertThat(position).isEqualTo(new Position(0, 0, expectedDirection));
    }
}
