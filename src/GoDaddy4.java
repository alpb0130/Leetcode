import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by alpb0130 on 2/13/16.
 * <p>
 * Closest Pairs
 * <p>
 * [1,2,3,5,7,8,10] --> 1,2,2,3,7,8
 * [1,2,3,4,5] --> 1,2,2,3,3,4,4,5
 */
public class GoDaddy4 {
    public ArrayList<Integer> closestPair(int[] array) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if (array == null || array.length < 1) return ret;
        Arrays.sort(array);
        int diff = Integer.MAX_VALUE;
        for (int i = 1; i < array.length; i++) {
            diff = array[i] - array[i - 1] < diff ? array[i] - array[i - 1] : diff;
        }
        for (int i = 1; i < array.length; i++) {
            if (array[i] - array[i - 1] == diff) {
                ret.add(array[i - 1]);
                ret.add(array[i]);
            }
        }
        return ret;
    }
}
