package lesson7_stacksAndQueues;

import java.util.Stack;

import static com.google.common.base.Preconditions.checkArgument;

public class StoneWall {

    /**
     * Indication: A - subsequence of array H.
     * We save one stone each time we find A in the H that meets one of the following requirements:
     * - A.length = 2 && A[0] = A[1].
     * - A.length > 2 && A[0] = A[A.length - 1] && A[1], A[2], ..., A[A.length - 2] > A[0].
     */

    public int solution(int[] H) {

        preconditions(H);

        int minRequiredStones = H.length;

        Stack<Integer> reusableStones = new Stack<>();

        for (int currentHeight : H) {
            while (!reusableStones.empty() && reusableStones.peek() > currentHeight) {
                reusableStones.pop();
            }
            if (reusableStones.empty() || reusableStones.peek() < currentHeight) {
                reusableStones.push(currentHeight);
            } else {
                minRequiredStones--;
            }
        }

        return minRequiredStones;
    }

    private void preconditions(int[] array) {

        final int minArrayLength = 1;
        final int maxArrayLength = 100_000;

        final int minArrayItemValue = 1;
        final int maxArrayItemValue = 1_000_000_000;

        final int arrayLength = array.length;

        checkArgument(
                arrayLength >= minArrayLength && arrayLength <= maxArrayLength,
                "Array must have length between " + minArrayLength + " and " + maxArrayLength
        );

        for (int item : array) {
            checkArgument(
                    item >= minArrayItemValue && item <= maxArrayItemValue,
                    "Each array item must be between " + minArrayItemValue + " and " + maxArrayItemValue
            );
        }
    }
}
