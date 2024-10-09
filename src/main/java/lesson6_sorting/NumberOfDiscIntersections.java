package lesson6_sorting;

import java.util.Arrays;

import static com.google.common.base.Preconditions.checkArgument;

public class NumberOfDiscIntersections {

    public int solution(int[] A) {
        preconditions(A);

        final int N = A.length;

        if (N == 0 || N == 1) {
            return 0;
        }

        long[] startPoints = new long[N];
        long[] endPoints = new long[N];

        for (int i = 0; i < N; i++) {
            startPoints[i] = (long) i - A[i];
            endPoints[i] = (long) i + A[i];
        }

        Arrays.sort(startPoints);
        Arrays.sort(endPoints);

        int intersectingPairsNumber = 0;
        int openDiscsNumber = 0;

        int j = 0;
        for (int i = 0; i < N; i++) {
            while (j < N && startPoints[j] <= endPoints[i]) {
                intersectingPairsNumber += openDiscsNumber++;
                if (intersectingPairsNumber > 10_000_000) {
                    return -1;
                }
                j++;
            }
            openDiscsNumber--;
        }

        return intersectingPairsNumber;
    }

    private static void preconditions(int[] A) {
        checkArgument(
                A.length <= 100_000,
                "Array length must be between less or equal than 100_000"
        );
        for (int arrayItem : A) {
            checkArgument(
                    arrayItem >= 0,
                    "Each array item must be greater or equal than 0"
            );
        }
    }
}