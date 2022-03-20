import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class FrogJmpTest {

    private final FrogJmp frogJmp = new FrogJmp();

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    public void should_return_correct_number_of_jumps(int X, int Y, int D, int expectedResult) {
        assertThat(frogJmp.solution(X, Y, D)).isEqualTo(expectedResult);
    }

    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                arguments(10, 85, 30, 3),
                arguments(20, 40, 20, 1),
                arguments(35, 37, 1, 2),
                arguments(4, 1500, 100, 15)
        );
    }
}
