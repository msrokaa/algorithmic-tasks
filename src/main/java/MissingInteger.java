import java.util.HashSet;

public class MissingInteger {
    public int solution(int[] A) {
        var set = new HashSet<Integer>();

        for (int item : A) {
            if (item > 0) {
                set.add(item);
            }
        }

        for (int i = 1; i <= set.size(); i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return set.size() + 1;
    }
}
