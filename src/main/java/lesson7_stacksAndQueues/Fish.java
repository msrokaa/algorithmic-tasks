package lesson7_stacksAndQueues;

import java.util.Stack;

import static com.google.common.base.Preconditions.checkArgument;

public class Fish {

    public int solution(int[] A, int[] B) {

        preconditions(A, B);

        Stack<Integer> liveFishes = new Stack<>();

        int downstreamFishesNumber = 0;

        for (int i = 0; i < A.length; i++) {
            if (B[i] == 1) { // Just add downstream fish.
                liveFishes.push(A[i]);
                downstreamFishesNumber++;
            } else if (downstreamFishesNumber == 0) { // Just add upstream fish with no fight.
                liveFishes.push(A[i]);
            } else { // Downstream fish in the stack means fight
                while (downstreamFishesNumber > 0) {
                    Integer downstreamFish = liveFishes.pop();
                    downstreamFishesNumber--;
                    if (downstreamFish > A[i]) { // Downstream fish won.
                        liveFishes.push(downstreamFish);
                        downstreamFishesNumber++;
                        break; // Go to the next fish from array 'A'.
                    } else if (downstreamFishesNumber == 0) { // Upstream fish won and there is no more fight for him.
                        liveFishes.push(A[i]); // Add upstream fish (which won) to the stack.
                    }
                }
            }
        }

        return liveFishes.size();
    }

    private void preconditions(int[] A, int[] B) {

        final int minArrayLength = 1;
        final int maxArrayLength = 100_000;

        final int minArrayItemValue = 0;
        final int maxArrayItemValue = 1_000_000_000;

        checkArgument(
                A.length >= minArrayLength
                        && A.length <= maxArrayLength
                        && B.length >= minArrayLength
                        && B.length <= maxArrayLength,
                "Both arrays must have a length between " + minArrayLength + " and " + maxArrayLength
        );

        checkArgument(
                A.length == B.length,
                "Both arrays must have the same length"
        );

        for (int i = 0; i < A.length; i++) {
            checkArgument(
                    A[i] >= minArrayItemValue && A[i] <= maxArrayItemValue,
                    "The item value of the array 'A' must be between " + minArrayItemValue + " and " + maxArrayItemValue
            );
            checkArgument(
                    B[i] == 0 || B[i] == 1,
                    "The item value of the array 'B' must be 0 or 1"
            );
        }
    }
}
