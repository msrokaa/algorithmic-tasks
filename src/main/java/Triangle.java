import java.util.Arrays;

import static com.google.common.base.Preconditions.checkArgument;

public class Triangle {
    public int solution(int[] A) {

        checkArgument(
                A.length <= 100_000,
                "Array length must be between less or equal than 100_000"
        );

        if (A.length < 3) {
            return 0;
        }

        Arrays.sort(A);

        for (int i = A.length - 3; i >= 0; i--) {

            int leftValue = A[i];
            int middleValue = A[i + 1];
            int rightValue = A[i + 2];

            if (leftValue <= 0) {
                return 0;
            }

            boolean triangleCond1 = leftValue > rightValue - middleValue;
            boolean triangleCond2 = leftValue > middleValue - rightValue;
            boolean triangleCond3 = middleValue > leftValue - rightValue;

            if (triangleCond1 && triangleCond2 && triangleCond3) {
                return 1;
            }
        }

        return 0;
    }
}
