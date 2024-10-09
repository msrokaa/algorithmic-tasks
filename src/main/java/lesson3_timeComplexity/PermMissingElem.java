package lesson3_timeComplexity;

public class PermMissingElem {
    public int solution(int[] A) {
        long arrayLength = A.length;
        long arraySum = 0;
        for (int item : A) {
            arraySum += item;
        }
        return (int) ((arrayLength + 2) * (arrayLength + 1) / 2 - arraySum);
    }
}
