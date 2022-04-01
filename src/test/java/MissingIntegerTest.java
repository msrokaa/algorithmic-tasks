import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MissingIntegerTest {

    private final MissingInteger missingInteger = new MissingInteger();

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    public void should_return_missing_integer(int[] A, int expectedResult) {
        assertThat(missingInteger.solution(A)).isEqualTo(expectedResult);
    }

    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                arguments(new int[]{1, 3, 6, 4, 1, 2}, 5),
                arguments(new int[]{1, 2, 3}, 4),
                arguments(new int[]{-1, -3}, 1),
                arguments(new int[]{-1000000, -90, -80, -5, 1, 20, 30, 40, 1000000}, 2),
                arguments(new int[]{-1, 1, 2, 3}, 4),
                arguments(new int[]{0, 0, 0, 0, 0}, 1)
        );
    }
}
