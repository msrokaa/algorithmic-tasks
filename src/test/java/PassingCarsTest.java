import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class PassingCarsTest {

    private final PassingCars passingCars = new PassingCars();

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    public void should_return_correct_pairs_number(int[] A, int expectedResult) {
        assertThat(passingCars.solution(A)).isEqualTo(expectedResult);
    }

    static Stream<Arguments> argumentsProvider() {
        var A = new int[63246];
        for (int i = 31623; i <= 63245; i++) {
            A[i] = 1; // 31623 zeros followed by 31623 ones => 1,000,014,129 pairs
        }

        return Stream.of(
                arguments(new int[]{0, 1, 0, 1, 1}, 5),
                arguments(new int[]{0, 0, 0, 0, 0}, 0),
                arguments(new int[]{1, 0, 0, 0, 0}, 0),
                arguments(new int[]{1, 0, 0, 0, 1, 0}, 3),
                arguments(A, -1)
        );
    }
}
