package lesson3_timeComplexity;

import static com.google.common.base.Preconditions.checkArgument;

public class FrogJmp {
    public int solution(int X, int Y, int D) {
        checkArgument(X >= 1 && X <= 1000000000, "'X' must be between 0 and 1000000000");
        checkArgument(Y >= 1 && Y <= 1000000000, "'Y' must be between 0 and 1000000000");
        checkArgument(D >= 1 && D <= 1000000000, "'D' must be between 0 and 1000000000");
        checkArgument(X <= Y, "'X' must be less than or equal to 'Y'");

        return (Y - X) % D == 0 ? (Y - X) / D : (Y - X) / D + 1;
    }
}
