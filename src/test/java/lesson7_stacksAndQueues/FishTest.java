package lesson7_stacksAndQueues;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class FishTest {

    private final Fish fish = new Fish();

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    public void should_return_correct_result(int[] A, int[] B, int expectedResult) {
        assertThat(fish.solution(A, B)).isEqualTo(expectedResult);
    }

    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                arguments(new int[]{1, 2, 3, 4, 5}, new int[]{0, 0, 0, 0, 0}, 5),
                arguments(new int[]{1, 2, 3, 4, 5}, new int[]{1, 1, 1, 1, 1}, 5),
                arguments(new int[]{1, 2, 4, 3, 5}, new int[]{0, 1, 1, 0, 0}, 2),
                arguments(new int[]{1, 2, 3, 4, 5}, new int[]{0, 0, 0, 0, 1}, 5),
                arguments(new int[]{5, 4, 3, 2, 1}, new int[]{1, 0, 0, 0, 0}, 1),
                arguments(new int[]{4, 3, 2, 1, 5}, new int[]{0, 1, 0, 0, 0}, 2)
        );
    }
}
