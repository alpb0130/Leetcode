/**
 * Created by alpb0130 on 2/26/16.
 */
public class PowerofThree {
    public boolean isPowerOfThree(int n) {
        if (n < 1) return false;
        while (n % 3 == 0)
            n /= 3;
        return n == 1;
    }
}
