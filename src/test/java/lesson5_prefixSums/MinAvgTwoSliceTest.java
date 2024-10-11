package lesson5_prefixSums;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MinAvgTwoSliceTest {

    private final MinAvgTwoSlice minAvgTwoSlice = new MinAvgTwoSlice();

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    public void should_return_correct_result(int[] A, int expectedResult) {
        assertThat(minAvgTwoSlice.solution(A)).isEqualTo(expectedResult);
    }

    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                arguments(new int[]{0, 0}, 0),
                arguments(new int[]{1, 1}, 0),
                arguments(new int[]{2, 1, 0}, 1),
                arguments(new int[]{4, 2, 2, 5, 1, 5, 8}, 1),
                arguments(new int[]{-3, -5, -8, -4, -10}, 2)
        );
    }
}
