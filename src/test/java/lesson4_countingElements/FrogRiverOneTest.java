package lesson4_countingElements;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class FrogRiverOneTest {

    private final FrogRiverOne frogRiverOne = new FrogRiverOne();

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    public void should_return_the_earliest_time(int[] A, int X, int expectedResult) {
        assertThat(frogRiverOne.solution(X, A)).isEqualTo(expectedResult);
    }

    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                arguments(new int[]{1, 3, 1, 4, 2, 3, 5, 4}, 5, 6),
                arguments(new int[]{4, 1, 3, 3, 1, 1, 1, 1, 2, 2, 3, 4}, 4, 8),
                arguments(new int[]{2, 1, 2, 2}, 2, 1),
                arguments(new int[]{1, 2, 3, 4}, 5, -1)
        );
    }
}
