package lesson5_prefixSums;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class GenomicRangeQueryTest {

    private final GenomicRangeQuery grq = new GenomicRangeQuery();

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    public void should_return_correct_result(String S, int[] P, int[] Q, int[] expectedResult) {
        assertThat(grq.solution(S, P, Q)).isEqualTo(expectedResult);
    }

    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                arguments("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6}, new int[]{2, 4, 1}),
                arguments("AAAAAA", new int[]{0, 0, 5}, new int[]{0, 5, 5}, new int[]{1, 1, 1}),
                arguments("ACGGCAT", new int[]{0, 0, 0, 3}, new int[]{2, 3, 4, 6}, new int[]{1, 1, 1, 1})
        );
    }
}
