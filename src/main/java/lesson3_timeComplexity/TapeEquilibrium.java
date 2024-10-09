package lesson3_timeComplexity;

public class TapeEquilibrium {
    public int solution(int[] A) {
        int leftSum = 0, rightSum = 0, difference = Integer.MAX_VALUE;
        for (int item : A) {
            rightSum += item;
        }
        for (int i = 0; i < A.length - 1; i++) {
            leftSum += A[i];
            rightSum -= A[i];
            difference = Math.min(Math.abs(leftSum - rightSum), difference);
        }
        return difference;
    }
}
