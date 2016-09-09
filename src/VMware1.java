import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by alpb0130 on 9/5/16.
 * <p>
 * Maximum difference between two elements such that
 * larger element appears after the smaller number
 * <p>
 * Given an array C[] of integers, find out the maximum difference between any
 * two elements such that larger element appears after the smaller number in C[].
 * <p>
 * Examples: If array is [2, 3, 10, 6, 4, 8, 1] then returned value should be 8
 * (Diff between 10 and 2). If array is [ 7, 9, 5, 6, 3, 2 ] then returned value
 * should be 2 (Diff between 7 and 9).
 * <p>
 * Input:
 * <p>
 * The first line of input contains an integer T denoting the number of test cases.
 * The first line of each test case is N,N is the size of array.
 * The second line of each test case contains N input C[i].
 * <p>
 * Output:
 * <p>
 * Print the maximum difference between two element. Otherwise print -1
 * <p>
 * Constraints:
 * 1 ≤ T ≤ 80
 * 2 ≤ N ≤ 100
 * 1 ≤ C[i] ≤ 500
 * <p>
 * Example:
 * <p>
 * Input:
 * 2
 * 7
 * 2 3 10 6 4 8 1
 * 5
 * 1 2 90 10 110
 * <p>
 * Output:
 * 8
 * 109
 */
public class VMware1 {
    public static void main(String[] args) {
        //code
        Scanner in = new Scanner(System.in);
        int caseNum = in.nextInt();
        int testNum;
        int[] nums = null;
        for (int i = 0; i < caseNum; i++) {
            testNum = in.nextInt();
            nums = new int[testNum];
            for (int j = 0; j < testNum; j++) {
                nums[j] = in.nextInt();
            }
            System.out.println(maxDiff(nums));
        }
    }

    public static int maxDiff(int[] nums) {
        if (nums == null || nums.length <= 1) return -1;
        int max = 0;
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int diff = nums[i] - min;
            if (diff > max) max = diff;
            if (nums[i] < min) min = nums[i];
        }
        return max == 0 ? -1 : max;
    }
}
