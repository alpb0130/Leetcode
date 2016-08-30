/**
 * Created by alpb0130 on 1/28/16.
 * <p>
 * 给一个数组，一个target，求Num of combinations that sums to the target。
 * e.g. [1, 2, 3] target = 3. return 4. [1, 1, 1], [1, 2], [2, 1], [3].
 */
public class Quora_1 {
    public int getNum(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i < target + 1; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0)
                    dp[i] += dp[i - nums[j]];
            }

        }
        return dp[target];
    }

    public int getNum1(int[] nums, int target) {
        if (target < 0) return 0;
        if (target == 0) return 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += getNum1(nums, target - nums[i]);
        }
        return sum;
    }
}
