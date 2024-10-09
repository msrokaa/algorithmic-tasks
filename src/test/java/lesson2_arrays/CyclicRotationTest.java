package lesson2_arrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class CyclicRotationTest {

    private final CyclicRotation cyclicRotation = new CyclicRotation();

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    public void should_return_correct_array(int[] A, int K, int[] expectedResult) {
        assertThat(cyclicRotation.solution(A, K)).isEqualTo(expectedResult);
    }

    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                arguments(new int[]{3, 8, 9, 7, 6}, 3, new int[]{9, 7, 6, 3, 8}),
                arguments(new int[]{0, 0, 0}, 1, new int[]{0, 0, 0}),
                arguments(new int[]{1, 2, 3, 4}, 4, new int[]{1, 2, 3, 4})
        );
    }
}
