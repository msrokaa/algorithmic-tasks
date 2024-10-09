package lesson6_sorting;

import java.util.Arrays;

public class Distinct {
    public int solution(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return 1;
        }

        Arrays.sort(A);

        int distinctValues = 1;

        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[i - 1]) {
                distinctValues++;
            }
        }

        return distinctValues;
    }
}