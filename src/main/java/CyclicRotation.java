import static com.google.common.base.Preconditions.checkArgument;

public class CyclicRotation {
    public int[] solution(int[] A, int K) {
        checkArgument(K >= 0 && K <= 100, "'K' must be between 0 and 100");
        checkArgument(A.length <= 100, "Length of 'A' must be less or equal to 100");

        int[] result = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            result[(i + K) % A.length] = A[i];
        }

        return result;
    }
}
