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

    @Test
    public void turn_left_to_south_from_west() {
        Position position = Mower.execute(0, 0, "W", "G");

        Assertions.assertThat(position.x()).isEqualTo(0);
        Assertions.assertThat(position.y()).isEqualTo(0);
        Assertions.assertThat(position.direction()).isEqualTo("S");
    }

    @Test
    public void turn_left_to_est_from_south() {
        Position position = Mower.execute(0, 0, "S", "G");

        Assertions.assertThat(position.x()).isEqualTo(0);
        Assertions.assertThat(position.y()).isEqualTo(0);
        Assertions.assertThat(position.direction()).isEqualTo("E");
    }

    @Test
    public void turn_left_to_north_from_est() {
        Position position = Mower.execute(0, 0, "E", "G");

        Assertions.assertThat(position.x()).isEqualTo(0);
        Assertions.assertThat(position.y()).isEqualTo(0);
        Assertions.assertThat(position.direction()).isEqualTo("N");
    }
}
