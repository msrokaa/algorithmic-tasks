import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class NumberOfDiscIntersectionsTest {

    private final NumberOfDiscIntersections numberOfDiscIntersections = new NumberOfDiscIntersections();

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    public void should_returns_number_of_unordered_pairs_of_intersecting_discs(int[] A, int expectedResult) {
        assertThat(numberOfDiscIntersections.solution(A)).isEqualTo(expectedResult);
    }

    static Stream<Arguments> argumentsProvider() {
        int[] array = new int[100_000];
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length - i;
        }
        return Stream.of(
                arguments(new int[0], 0),
                arguments(new int[]{1}, 0),
                arguments(new int[]{1, 1}, 1),
                arguments(new int[]{1, 1, 1}, 3),
                arguments(new int[]{1, 1, 1, 4}, 6),
                arguments(array, -1), // Intersections number exceeds 10_000_000
                arguments(new int[]{1, 5, 2, 1, 4, 0}, 11),
                arguments(new int[]{1, Integer.MAX_VALUE, 0}, 2)
        );
    }
}
