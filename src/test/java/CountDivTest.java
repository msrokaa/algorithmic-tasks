import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CountDivTest {

    private final CountDiv countDiv = new CountDiv();

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    public void should_return_correct_result(int A, int B, int K, int expectedResult) {
        assertThat(countDiv.solution(A, B, K)).isEqualTo(expectedResult);
    }

    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                arguments(6, 11, 2, 3),
                arguments(1, 8, 9, 0),
                arguments(0, 13, 1, 14),
                arguments(2, 15, 5, 3),
                arguments(10, 10, 5, 1),
                arguments(10, 10, 7, 0),
                arguments(10, 10, 20, 0),
                arguments(10, 11, 11, 1),
                arguments(0, 0, 11, 1),
                arguments(0, 2_000_000_000, 2_000_000_000, 2)
        );
    }
}
