package lesson7_stacksAndQueues;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class BracketsTest {

    private final Brackets brackets = new Brackets();

    @ParameterizedTest
    @MethodSource("argumentsProvider")
    public void should_return_correct_result(String S, int expectedResult) {
        assertThat(brackets.solution(S)).isEqualTo(expectedResult);
    }

    static Stream<Arguments> argumentsProvider() {
        return Stream.of(
                arguments("", 1),
                arguments("[]", 1),
                arguments("[]()", 1),
                arguments("[](){}", 1),
                arguments("{[](){}}", 1),
                arguments("{[()()][]}{}[]", 1),
                arguments("{[()]}", 1),
                arguments("{()()}", 1),
                arguments("{(()()}", 0),
                arguments("{", 0),
                arguments("}", 0),
                arguments("{}}", 0),
                arguments("{{}", 0),
                arguments("(((", 0),
                arguments(")))", 0),
                arguments("([)()]", 0)
        );
    }
}
