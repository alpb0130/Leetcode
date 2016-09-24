import java.util.ArrayList;
import java.util.List;

/**
 * Created by alpb0130 on 1/4/16.
 * <p>
 * 228. Summary Ranges
 * <p>
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * <p>
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<String>();
        if (nums == null || nums.length == 0) return list;
        int start = 0, end = -1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                if (start + 1 == i) {
                    list.add(Integer.toString(nums[start]));
                } else {
                    list.add(String.format("%d->%d", nums[start], nums[end]));
                }
                start = i;
            }
            end = i;
        }
        if (start == nums.length - 1) list.add(Integer.toString(nums[start]));
        else list.add(String.format("%d->%d", nums[start], nums[end]));
        return list;
    }

    // Much clearer method
    public List<String> summaryRanges1(int[] nums) {
        int length = nums.length;
        List<String> result = new ArrayList<String>(length);
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            while (i < length - 1 && nums[i] + 1 == nums[i + 1]) {
                i++;
            }
            if (num != nums[i]) {
                result.add(num + "->" + nums[i]);
            } else {
                result.add(num + "");
            }
        }
        return result;
    }
}
