package lesson4_countingElements;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PermCheckTest {

    private final PermCheck permCheck = new PermCheck();

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    public void should_return_correct_result(int[] A, int expectedResult) {
        assertThat(permCheck.solution(A)).isEqualTo(expectedResult);
    }

    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                arguments(new int[]{4, 1, 3, 2}, 1),
                arguments(new int[]{6, 3, 4, 5, 2, 1}, 1),
                arguments(new int[]{4, 1, 3}, 0),
                arguments(new int[]{1, 2, 2, 3, 3, 4}, 0)
        );
    }
}
