package lesson4_countingElements;

import static com.google.common.base.Preconditions.checkArgument;

public class PermCheck {
    public int solution(int[] A) {
        checkArgument(
                A.length >= 1 && A.length <= 100000,
                "Length of 'A' array must be between 1 and 100000"
        );

        var occurred = new boolean[A.length];
        for (int item : A) {
            if (item < 1 || item > A.length) {
                return 0;
            }
            if (occurred[item - 1]) {
                return 0;
            }
            occurred[item - 1] = true;
        }

        return 1;
    }
}
