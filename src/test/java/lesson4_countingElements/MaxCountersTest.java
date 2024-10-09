package lesson4_countingElements;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MaxCountersTest {

    private final MaxCounters maxCounters = new MaxCounters();

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    public void should_return_correct_array(int N, int[] A, int[] expectedResult) {
        assertThat(maxCounters.solution(N, A)).isEqualTo(expectedResult);
    }

    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                arguments(5, new int[]{3, 4, 4, 6, 1, 4, 4}, new int[]{3, 2, 2, 4, 2}),
                arguments(3, new int[]{4, 4, 4}, new int[]{0, 0, 0}),
                arguments(3, new int[]{2, 4, 4}, new int[]{1, 1, 1}),
                arguments(3, new int[]{2, 4, 4, 1, 4}, new int[]{2, 2, 2})
        );
    }
}
