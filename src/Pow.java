/**
 * Created by alpb0130 on 9/11/16.
 * <p>
 * 50. Pow(x, n)
 * <p>
 * Implement pow(x, n).
 */
public class Pow {
    // O(n) method is not good. Try to use O(log n) method. Divide and conquer.
    // Iterative.
    // Time: O(logn)
    // Space: O(1)
    double myPow(double x, int n) {
        if (n == 0) return 1;
        // If n is Integer.MIN_VALUE
        long nn = n;
        if (nn < 0) {
            nn = -nn;
            x = 1 / x;
        }
        double ret = 1.0;
        while (nn > 0) {
            if (nn % 2 == 1) ret *= x;
            x *= x;
            nn /= 2;
        }
        return ret;
    }

    // Recursive
    // Time: O(logn)
    double myPow1(double x, int n) {
        if (n == 0) return 1;
        long nn = n;

        if (nn < 0) {
            nn = -nn;
            x = 1 / x;
        }
        return (nn % 2 == 1) ? x * myPow(x * x, (int) (nn / 2)) : myPow(x * x, (int) (nn / 2));
    }
}
