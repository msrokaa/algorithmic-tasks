package lesson5_prefixSums;

import static com.google.common.base.Preconditions.checkArgument;

public class MinAvgTwoSlice {

    public int solution(int[] A) {

        preconditions(A);

        int startingPosition = -1;
        double minAvg = Double.MAX_VALUE;

        if (A.length == 2) {
            return 0;
        }

        /*
        There always exists at least one subarray of length 2 or 3 that has an equal or lower average than
        the whole array. Therefore, the minimum average will occur in a subarray of length 2 or 3.
        If there are extremely large or small values in the whole array, the average will stabilize,
        but smaller fragments can capture these more extreme values. In the case of an array consisting
        of 4 elements, we can create 2 sub-arrays, each with 2 elements, and one of them will have an average
        that is equal to or lower than the four-element array.
        */

        for (int i = 0; i < A.length - 1; i++) {
            double avg1 = (double) (A[i] + A[i + 1]) / 2;
            double avg2 = i + 2 < A.length
                    ? (double) (A[i] + A[i + 1] + A[i + 2]) / 3
                    : Double.MAX_VALUE;
            double currentMinAvg = Math.min(avg1, avg2);
            if (currentMinAvg < minAvg) {
                minAvg = currentMinAvg;
                startingPosition = i;
            }
        }

        return startingPosition;
    }

    private void preconditions(int[] A) {

        final int minArrayLength = 2;
        final int maxArrayLength = 10_000;

        final int minArrayItemValue = -10_000;
        final int maxArrayItemValue = 10_000;

        checkArgument(
                A.length >= minArrayLength && A.length <= maxArrayLength,
                "Array length must be between " + minArrayLength + " and " + maxArrayLength
        );

        for (int item : A) {
            checkArgument(
                    item >= minArrayItemValue && item <= maxArrayItemValue,
                    "Each array item value must be between " + minArrayItemValue + " and " + maxArrayItemValue
            );
        }
    }
}
