import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class DistinctTest {

    private final Distinct distinct = new Distinct();

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    public void should_return_correct_result(int[] A, int expectedResult) {
        assertThat(distinct.solution(A)).isEqualTo(expectedResult);
    }

    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                arguments(new int[0], 0),
                arguments(new int[]{123}, 1),
                arguments(new int[]{123, 123}, 1),
                arguments(new int[]{456, 123}, 2),
                arguments(new int[]{123, 123, 123}, 1),
                arguments(new int[]{789, 456, 123}, 3),
                arguments(new int[]{456, 456, 123}, 2),
                arguments(new int[]{789, 456, 456, 123, 123}, 3)
        );
    }
}
