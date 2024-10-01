import java.util.Arrays;

import static com.google.common.base.Preconditions.checkArgument;

public class MaxProductOfThree {
    public int solution(int[] A) {

        checkArgument(
                A.length >= 3 && A.length <= 100_000,
                "Array length must be between 3 and 100_000"
        );

        if (A.length == 3) {
            return A[0] * A[1] * A[2];
        }

        Arrays.sort(A);

        int firstItem = A[0];
        int secondItem = A[1];

        int thirdFromLastItem = A[A.length - 3];
        int secondFromLastItem = A[A.length - 2];
        int lastItem = A[A.length - 1];

        if (firstItem >= 0 || lastItem <= 0) {
            return thirdFromLastItem * secondFromLastItem * lastItem;
        }

        if (secondFromLastItem < 0 || thirdFromLastItem < 0) {
            return firstItem * secondItem * lastItem;
        }

        return Math.max(
                thirdFromLastItem * secondFromLastItem * lastItem,
                firstItem * secondItem * lastItem
        );
    }
}
