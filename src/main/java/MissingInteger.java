import java.util.TreeSet;

public class MissingInteger {
    public int solution(int[] A) {
        var set = new TreeSet<Integer>();
        for (int item : A) {
            if (item > 0) {
                set.add(item);
            }
        }
        int counter = 1;
        for (int item : set) {
            if (item != counter) {
                return counter;
            }
            counter++;
        }
        return set.size() + 1;
    }
}
