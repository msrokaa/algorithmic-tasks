import java.util.Stack;

public class Brackets {

    public int solution(String S) {

        Stack<Character> openingBrackets = new Stack<>();
        Stack<Character> closingBrackets = new Stack<>();

        for (char currentChar : S.toCharArray()) {
            if (isBracketOpening(currentChar)) {
                openingBrackets.push(currentChar);
                closingBrackets.push(getClosingBracketOf(currentChar));
            } else if (!closingBrackets.isEmpty() && currentChar == closingBrackets.pop()) {
                openingBrackets.pop();
            } else {
                return 0;
            }
        }

        return openingBrackets.isEmpty() && closingBrackets.isEmpty() ? 1 : 0;
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
}
