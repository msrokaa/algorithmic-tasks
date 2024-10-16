package lesson7_stacksAndQueues;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class StoneWallTest {

    private final StoneWall stoneWall = new StoneWall();

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    public void should_return_minimum_stones_number(int[] H, int expectedResult) {
        assertThat(stoneWall.solution(H)).isEqualTo(expectedResult);
    }

    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                arguments(new int[]{2}, 1),
                arguments(new int[]{2, 2}, 1),
                arguments(new int[]{2, 3}, 2),
                arguments(new int[]{3, 2}, 2),
                arguments(new int[]{2, 2, 2}, 1),
                arguments(new int[]{2, 2, 3}, 2),
                arguments(new int[]{2, 3, 4}, 3),
                arguments(new int[]{8, 8, 5, 7, 9, 8, 7, 4, 8}, 7),
                arguments(new int[]{5, 6, 7, 5, 6, 7, 5, 4, 5, 6, 5, 3, 5}, 10),
                arguments(new int[]{4, 5, 3, 5, 4, 6, 5, 7, 4, 9, 3, 2, 6, 9, 8, 6, 7, 8, 6, 1, 2, 3}, 18)
        );
    }
}
