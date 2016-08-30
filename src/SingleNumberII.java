import java.util.HashMap;

/**
 * Created by alpb0130 on 1/8/16.
 * <p>
 * 137. Single Number II
 * <p>
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * <p>
 * Time complexity: O(n) and O(k * n) and O(n)
 * Space complexity: O(n) and O(1) and O(1)
 */
public class SingleNumberII {
    // Bit manipulation. O(32 * n). O(1)
    public int singleNumber1(int[] nums) {
        int[] bits = new int[32];
        int ret = 0;
        for (int i : nums) {
            for (int j = 0; j < 32; j++) {
                boolean flag = !((i & (1 << j)) == 0);
                if (flag)
                    bits[j] = (bits[j] + 1) % 3;
            }
        }
        for (int i = 0; i < 32; i++) {
            if (bits[i] != 0)
                ret += (1 << i);
        }
        return ret;
    }

    // Bit manipulation. O(n). O(1). Trickkkkkkkkkkky!!
    public int singleNumber2(int[] nums) {
        int a = 0, b = 0;
        for (int c : nums) {
            int aa = (a & ~b & ~c) | (~a & b & c);
            b = (~a & b & ~c) | (~a & ~b & c);
            a = aa;
        }
        return a | b;
    }
}
