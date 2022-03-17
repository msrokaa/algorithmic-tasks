package binarygap;

import static com.google.common.base.Preconditions.checkArgument;

public class Solution {
    public int solution(int N) {
        checkArgument(N > 0, "'N' must be positive");
        if (N < 4) {
            return 0;
        }

        char[] bin = Integer.toBinaryString(N).toCharArray();
        int binaryGapMax = 0;
        int lastOneIndex = 0;

        for (int i = 1; i < bin.length; i++) {
            if (bin[i] == '1') {
                binaryGapMax = Math.max(i - lastOneIndex - 1, binaryGapMax);
                lastOneIndex = i;
            }
        }

        return binaryGapMax;
    }
}
