import java.util.ArrayList;
import java.util.List;

/**
 * Created by alpb0130 on 9/19/16.
 * <p>
 * 163. Missing Ranges
 * Given a sorted integer array where the range of elements
 * are [lower, upper] inclusive, return its missing ranges.
 * <p>
 * For example, given [0, 1, 3, 50, 75], lower = 0 and
 * upper = 99, return ["2", "4->49", "51->74", "76->99"].
 */
public class MissingRange {
    // Time: O(n)
    // Space: O(1)
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> list = new ArrayList<String>();
        int pre = lower;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == pre + 1) {
                list.add(Integer.toString(pre));
            } else if (nums[i] > pre + 1) {
                list.add(String.format("%d->%d", pre + 1, nums[i] - 1));
            }
            pre = nums[i] + 1;
        }
        if (pre == upper) list.add(Integer.toString(pre));
        if (pre < upper) list.add(String.format("%d->%d", pre, upper));
        return list;
    }
}
