import java.util.HashSet;

/**
 * Created by alpb0130 on 2/4/16.
 * <p>
 * 202. Happy Number
 * <p>
 * Write an algorithm to determine if a number is "happy".
 * <p>
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will stay),
 * or it loops endlessly in a cycle which does not include 1. Those numbers for
 * which this process ends in 1 are happy numbers.
 * Example: 19 is a happy number
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 */
public class HappyNumber {
    // Use a hashset to copy wiht replication.
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        int sum = n;
        set.add(sum);
        while (sum != 0) {
            int temp = 0;
            while (sum != 0) {
                temp += Math.pow(sum % 10, 2);
                sum /= 10;
            }
            if (temp == 1) return true;
            sum = temp;
            if (!set.add(sum)) return false;
        }
        return false;
    }
}
