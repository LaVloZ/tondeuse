import lv.merrill.Mower;
import lv.merrill.Position;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
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

        Assertions.assertThat(position.x()).isEqualTo(0);
        Assertions.assertThat(position.y()).isEqualTo(0);
        Assertions.assertThat(position.direction()).isEqualTo(expectedDirection);
    }
}
