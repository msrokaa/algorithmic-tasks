package lesson4_countingElements;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;

public class MaxCounters {
    public int[] solution(int N, int[] A) {
        checkArgument(
                N >= 1 && N <= 100000,
                "'N' array must be between 1 and 100000"
        );
        checkArgument(
                A.length >= 1 && A.length <= 100000,
                "Length of 'A' array must be between 1 and 100000"
        );
        for (int item : A) {
            checkArgument(
                    item >= 1 && item <= N + 1,
                    "Each element of array 'A' must be between 1 and N+1"
            );
        }

        var occurrences = new HashMap<Integer, Integer>();
        int maxCounter = 0;

        for (int item : A) {
            if (item < N + 1) {
                occurrences.merge(item, 1, Integer::sum);
            } else if (item == N + 1 && !occurrences.isEmpty()) {
                maxCounter += Collections.max(occurrences.values());
                occurrences.clear();
            }
        }

        var counters = new int[N];
        Arrays.fill(counters, maxCounter);

        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            counters[entry.getKey() - 1] += entry.getValue();
        }

        return counters;
    }
}
