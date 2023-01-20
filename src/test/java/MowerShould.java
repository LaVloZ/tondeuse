import lv.merrill.Mower;
import lv.merrill.Position;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MowerShould {

    @Test
    public void turn_left_to_west_from_north() {
        Position position = Mower.execute(0, 0, "N", "G");

        Assertions.assertThat(position.x()).isEqualTo(0);
        Assertions.assertThat(position.y()).isEqualTo(0);
        Assertions.assertThat(position.direction()).isEqualTo("W");
    }
}
