package lesson6_sorting;

import java.util.Arrays;

import static com.google.common.base.Preconditions.checkArgument;

public class MaxProductOfThree {
    public int solution(int[] A) {

        checkArgument(
                A.length >= 3 && A.length <= 100_000,
                "Array length must be between 3 and 100_000"
        );

        Arrays.sort(A);

        return Math.max(
                A[0] * A[1] * A[A.length - 1],
                A[A.length - 3] * A[A.length - 2] * A[A.length - 1]
        );
    }
}
