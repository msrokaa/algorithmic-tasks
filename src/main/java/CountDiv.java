import static com.google.common.base.Preconditions.checkArgument;

public class CountDiv {
    public int solution(int A, int B, int K) {
        checkArgument(A >= 0 && A <= 2_000_000_000, "'A' must be between 0 and 2 000 000 000");
        checkArgument(B >= 0 && B <= 2_000_000_000, "'B' must be between 0 and 2 000 000 000");
        checkArgument(K >= 1 && K <= 2_000_000_000, "'K' must be between 1 and 2 000 000 000");
        checkArgument(A <= B, "'A' must be less than or equal to 'B'");

        int rest = A % K;
        int firstDivisible = rest == 0 ? A : A + K - rest;

        if (firstDivisible > B) return 0;

        return (B - firstDivisible) / K + 1;
    }
}
