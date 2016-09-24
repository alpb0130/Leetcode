/**
 * Created by alpb0130 on 2/11/16.
 * <p>
 * 7. Reverse Integer
 * <p>
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 */
public class ReverseInteger {
    // Take care of overflow. Time complexity: O(n).
    // Space: O(1)
    public int reverse(int x) {
        long y = 0;
        while (x != 0) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        if (y > Integer.MAX_VALUE || y < Integer.MIN_VALUE)
            return 0;
        return (int) y;
    }
}
