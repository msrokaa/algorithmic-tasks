import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TapeEquilibriumTest {

    private final TapeEquilibrium tapeEquilibrium = new TapeEquilibrium();

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    public void should_return_minimal_difference(int[] A, int expectedResult) {
        assertThat(tapeEquilibrium.solution(A)).isEqualTo(expectedResult);
    }

    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                arguments(new int[]{-3, 3}, 6),
                arguments(new int[]{3, 1, 2, 4, 3}, 1),
                arguments(new int[]{5, 11, 0, 3, 2, 8}, 3),
                arguments(new int[]{0, 0, 0}, 0),
                arguments(new int[]{2, 2, 2, 2}, 0),
                arguments(new int[]{-1, -2, -3, -4, -5}, 3)
        );
    }
}
