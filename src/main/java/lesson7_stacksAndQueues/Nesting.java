package lesson7_stacksAndQueues;

import static com.google.common.base.Preconditions.checkArgument;

public class Nesting {

    public int solution(String S) {

        preconditions(S);

        int openingBracketsNumber = 0;

        for (char currentChar : S.toCharArray()) {
            if (currentChar == '(') {
                openingBracketsNumber++;
            } else if (openingBracketsNumber > 0) {
                openingBracketsNumber--;
            } else {
                return 0;
            }
        }

        return openingBracketsNumber == 0 ? 1 : 0;
    }

    private void preconditions(String S) {

        final int maxArrayLength = 1_000_000;

        checkArgument(
                S.length() <= maxArrayLength,
                "String length must be less or equal than " + maxArrayLength
        );

        for (char currentChar : S.toCharArray()) {
            checkArgument(
                    currentChar == '(' || currentChar == ')',
                    "Each char must be a valid bracket '(' or ')'"
            );
        }
    }
}
