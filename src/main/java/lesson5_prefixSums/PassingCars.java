package lesson5_prefixSums;

public class PassingCars {
    public int solution(int[] A) {
        final int pairsLimit = 1_000_000_000;
        int zeros = 0;
        int pairs = 0;

        for (int item : A) {
            switch (item) {
                case 0 -> zeros++;
                case 1 -> {
                    pairs += zeros;
                    if (pairs > pairsLimit) {
                        return -1;
                    }
                }
            }
        }

        return pairs;
    }
}
