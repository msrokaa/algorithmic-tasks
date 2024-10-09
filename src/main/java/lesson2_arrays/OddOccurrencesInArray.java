package lesson2_arrays;

import java.util.HashMap;
import java.util.Map;

public class OddOccurrencesInArray {
    public int solution(int[] A) {
        var occurrences = new HashMap<Integer, Integer>();
        for (int item : A) {
            occurrences.merge(item, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("An integer with odd number of occurrences does not exist in the array");
    }
}
