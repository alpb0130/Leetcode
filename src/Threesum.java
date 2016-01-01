/**
 * Created by alpb0130 on 10/1/15.
 * <p>
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets
 * in the array which gives the sum of zero.
 * <p>
 * Note:
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 * For example, given array S = {-1 0 1 2 -1 -4},
 * A solution set is:
 * (-1, 0, 1)
 * (-1, -1, 2)
 */

import java.util.*;

public class Threesum {
    // Unaccepted solution
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ArrayList<Integer> sumList = new ArrayList<Integer>();
                        sumList.add(nums[i]);
                        sumList.add(nums[j]);
                        sumList.add(nums[k]);
                        Arrays.sort(sumList.toArray());
                        if (!list.contains(sumList)) {
                            list.add(sumList);
                        }
                    }
                }
            }
        }
        return list;
    }

    // Much faster solution. Time Complexity: O(n^2)
    public List<List<Integer>> threeSum1(int[] nums) {
        ArrayList<List<Integer>> list = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) return list;
        Arrays.sort(nums);
        int l = nums.length;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int j = i + 1, k = l - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    ArrayList templist = new ArrayList();
                    templist.add(nums[i]);
                    templist.add(nums[j]);
                    templist.add(nums[k]);
                    list.add(templist);
                    while (j < k && nums[j] == nums[j + 1]) j++;
                    while (j < k && nums[k] == nums[k - 1]) k--;
                    k--;
                    j++;
                } else if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                }
            }
        }
        return list;
    }
}
