package lesson3_timeComplexity;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PermMissingElemTest {

    private final PermMissingElem permMissingElem = new PermMissingElem();

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    public void should_return_correct_missing_element(int[] A, int expectedResult) {
        assertThat(permMissingElem.solution(A)).isEqualTo(expectedResult);
    }

    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                arguments(new int[]{2, 3, 1, 5}, 4),
                arguments(new int[]{3, 1, 2, 4, 8, 7, 5}, 6),
                arguments(new int[]{11, 9, 7, 1, 4, 6, 2, 3, 5, 8}, 10)
        );
    }
}
