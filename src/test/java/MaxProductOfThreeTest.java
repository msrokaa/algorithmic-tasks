import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MaxProductOfThreeTest {

    private final MaxProductOfThree maxProductOfThree = new MaxProductOfThree();

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    public void should_return_max_product_of_three(int[] A, int expectedResult) {
        assertThat(maxProductOfThree.solution(A)).isEqualTo(expectedResult);
    }

    static Stream<Arguments> argumentsProvider() {
        return Stream.of(

                arguments(new int[]{0, 1, 2, 3, 4, 5}, 60), // 3 * 4 * 5
                arguments(new int[]{1, 2, 3, 4, 5, 6}, 120), // 4 * 5 * 6
                arguments(new int[]{-6, -5, -4, -3, -2, -1}, -6), // -3 * (-2) * (-1)
                arguments(new int[]{-5, -4, -3, -2, -1, 0}, 0), // -2 * (-1) * 0

                arguments(new int[]{-5, -4, -3, -2, -1, 10}, 200), // -5 * (-4) * 10
                arguments(new int[]{-4, -3, -2, -1, 10, 20}, 240), // -4 * (-3) * 20

                arguments(new int[]{-3, -2, -1, 10, 20, 30}, 6000), // 10 * 20 * 30
                arguments(new int[]{-30, -20, -10, 1, 2, 3}, 1800), // -30 * (-20) * 3

                arguments(new int[]{-3, -2, 1, 2, 5, 6}, 60), // 2 * 5 * 6
                arguments(new int[]{-3, 1, 1, 2, 5, 6}, 60), // 2 * 5 * 6
                arguments(new int[]{-3, 0, 1, 2, 5, 6}, 60), // 2 * 5 * 6
                arguments(new int[]{-10, -2, 1, 2, 5, 6}, 120) // -10 * (-2) * 6
        );
    }
}
