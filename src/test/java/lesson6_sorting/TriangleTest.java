package lesson6_sorting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class TriangleTest {

    private final Triangle triangle = new Triangle();

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    public void should_determine_if_array_contains_triangular_triplet(int[] A, int expectedResult) {
        assertThat(triangle.solution(A)).isEqualTo(expectedResult);
    }

    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                arguments(new int[0], 0),
                arguments(new int[]{5}, 0),
                arguments(new int[]{5, 10}, 0),
                arguments(new int[]{5, 5, 10}, 0),
                arguments(new int[]{5, 6, 10}, 1),
                arguments(new int[]{-3, -2, -1, 0, 1, 2, 3, 4}, 1), // [2, 3, 4]
                arguments(new int[]{1, 5, 5, 5}, 1), // [1, 5, 5] or [5, 5, 5]
                arguments(new int[]{-3, -2, -1, 0, 1, 2, 3}, 0),
                arguments(new int[]{45, 50, 100, 140}, 1), // [45, 100, 140] or [50, 100, 140]
                arguments(new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE}, 0),
                arguments(new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE}, 1)
        );
    }
}
