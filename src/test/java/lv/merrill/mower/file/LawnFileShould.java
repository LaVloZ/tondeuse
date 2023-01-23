package lv.merrill.mower.file;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class LawnFileShould {

    @Test
    public void parse_file() throws IOException {
        LawnFile lawnFile = new LawnFile("src/test/resources/file/mower.txt");

        String result = lawnFile.result();

        Assertions.assertThat(result).isEqualTo("""
                1 3 N
                5 1 E
                """);
    }
}
