import java.util.Scanner;

/**
 * Created by alpb0130 on 9/5/16.
 * <p>
 * Consecutive Subsequences
 * link: https://www.hackerrank.com/contests/w6/challenges/consecutive-subsequences
 */
public class VMware2 {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int caseNum = in.nextInt();
        int testNum;
        int k;
        int[] nums = null;
        for (int i = 0; i < caseNum; i++) {
            testNum = in.nextInt();
            k = in.nextInt();
            nums = new int[testNum];
            for (int j = 0; j < testNum; j++) {
                nums[j] = in.nextInt();
            }
            System.out.println(numOfSubsequence(nums, k));
        }
    }

    public static long numOfSubsequence(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        long res = 0;
        long sum = 0;
        long[] remainder = new long[k];
        remainder[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            remainder[(int)(sum % (long)k)]++;
        }
        for (int i = 0; i < k; i++) {
            if (remainder[i] > 1) res += remainder[i] * (remainder[i] - 1) / 2;
        }
        return res;
    }
}
