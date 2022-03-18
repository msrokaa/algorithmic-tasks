import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BinaryGapTest {

    private final BinaryGap binaryGap = new BinaryGap();

    @ParameterizedTest
    @CsvSource({
            "1, 0",
            "2, 0",
            "3, 0",
            "4, 0",
            "9, 2",
            "529, 4",
            "20, 1",
            "15, 0",
            "1041, 5",
            "32, 0",
    })
    public void should_return_correct_binary_gap(int N, int expectedBinaryGap) {
        assertThat(binaryGap.solution(N)).isEqualTo(expectedBinaryGap);
    }
}
