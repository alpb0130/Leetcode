/**
 * Created by alpb0130 on 10/1/15.
 */

import java.util.*;

public class Threesum {
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
}
