import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class OddOccurrencesInArrayTest {

    private final OddOccurrencesInArray oddOccurrences = new OddOccurrencesInArray();

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    public void should_return_item_with_odd_occurrences(int[] A, int expectedResult) {
        assertThat(oddOccurrences.solution(A)).isEqualTo(expectedResult);
    }

    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                arguments(new int[]{9, 3, 9, 3, 9, 7, 9}, 7),
                arguments(new int[]{5, 5, 5}, 5),
                arguments(new int[]{3}, 3),
                arguments(new int[]{2, 6, 5, 2, 6, 5, 2}, 2)
        );
    }
}
