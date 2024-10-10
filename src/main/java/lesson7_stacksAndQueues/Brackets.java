package lesson7_stacksAndQueues;

import java.util.Stack;

import static com.google.common.base.Preconditions.checkArgument;

public class Brackets {

    public int solution(String S) {

        preconditions(S);

        Stack<Character> openingBrackets = new Stack<>();

        for (char currentChar : S.toCharArray()) {
            if (isBracketOpening(currentChar)) {
                openingBrackets.push(currentChar);
            } else if (openingBrackets.isEmpty() || currentChar != getClosingBracketOf(openingBrackets.pop())) {
                return 0;
            }
        }

        return openingBrackets.isEmpty() ? 1 : 0;
    }

    private boolean isBracketOpening(char bracket) {
        return bracket == '{' || bracket == '[' || bracket == '(';
    }

    private char getClosingBracketOf(char bracket) {
        return switch (bracket) {
            case '{' -> '}';
            case '[' -> ']';
            case '(' -> ')';
            default -> throw new IllegalArgumentException("Invalid bracket: " + bracket);
        };
    }

    private void preconditions(String S) {
        checkArgument(
                S.length() <= 200_000,
                "String length must be less or equal than 200_000"
        );

        for (char currentChar : S.toCharArray()) {
            checkArgument(currentChar == '{'
                            || currentChar == '}'
                            || currentChar == '['
                            || currentChar == ']'
                            || currentChar == '('
                            || currentChar == ')',
                    "Each char must be a valid bracket"
            );
        }
    }
}
