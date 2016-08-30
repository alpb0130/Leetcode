import java.util.ArrayList;
import java.util.List;

/**
 * Created by alpb0130 on 1/29/16.
 * <p>
 * 46. Permutations
 * <p>
 * Given a collection of distinct numbers, return all possible permutations.
 * <p>
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 */
public class Permutation {
    // Time complexity: O(P(n, n)).
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) return ll;
        permute(nums, ll, 0, new ArrayList<Integer>());
        return ll;
    }

    public void permute(int[] nums, List<List<Integer>> ll, int num, List<Integer> l) {
        if (num == nums.length) {
            ll.add(l);
            return;
        }
        for (int i = 0; i <= num; i++) {
            ArrayList<Integer> temp_list = new ArrayList<Integer>(l);
            temp_list.add(i, nums[num]);
            permute(nums, ll, num + 1, temp_list);
        }
        return;
    }
}
