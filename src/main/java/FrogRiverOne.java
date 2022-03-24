import static com.google.common.base.Preconditions.checkArgument;

public class FrogRiverOne {
    public int solution(int X, int[] A) {
        checkArgument(
                X >= 1 && X <= 100000,
                "'X' must be between 1 and 100000"
        );
        checkArgument(
                A.length >= 1 && A.length <= 100000,
                "Length of 'A' array must be between 1 and 100000"
        );
        var fallen = new boolean[X];
        int readyPositionsCounter = 0;
        int seconds = 0;
        for (int item : A) {
            if (item < 1 || item > X) {
                throw new RuntimeException("Each element of array must be an integer within the range [1..X]");
            }
            seconds++;
            if (!fallen[item - 1]) {
                fallen[item - 1] = true;
                if (++readyPositionsCounter == X) {
                    return seconds - 1;
                }
            }
        }
        return -1;
    }
}
