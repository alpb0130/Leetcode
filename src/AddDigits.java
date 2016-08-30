/**
 * Created by alpb0130 on 1/7/16.
 *
 * 258. Add Digits
 *
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * For example:
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 *
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
public class AddDigits {
    // Recursive style
    public int addDigits(int num) {
        if (num / 10 == 0) return num;
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return addDigits(sum);
    }
    // Iterative style
    public int addDigits1(int num) {
        if (num / 10 == 0) return num;
        while (num / 10 != 0) {
            int sum = 0;
            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        }
        return num;
    }
    // O(1) method
    public int addDigits2(int num) {
        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
        return num % 9;
    }
    // Much less code
    public int addDigits3(int num) {
        return (num - 1) % 9 + 1;
    }
}

