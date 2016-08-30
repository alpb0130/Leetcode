/**
 * Created by alpb0130 on 1/12/16.
 * <p>
 * 263. Ugly Number
 * <p>
 * Write a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * <p>
 * Note that 1 is typically treated as an ugly number.
 */
public class UglyNumber {
    // Recursive. Be careful with non-positive number and 1.
    public boolean isUgly(int num) {
        if (num <= 0) return false;
        if (num == 1) return true;
        if (num == 2) return true;
        if (num == 3) return true;
        if (num == 5) return true;
        return ((num % 2 == 0) && isUgly(num / 2)) ||
                ((num % 3 == 0) && isUgly(num / 3)) ||
                ((num % 5 == 0) && isUgly(num / 5));
    }

    // Iterative.
    public boolean isUgly1(int num) {
        if (num <= 0) {
            return false;
        }
        while ((num % 2) == 0) {
            //number is divisible by 2
            num = num / 2;
        }
        while (num % 3 == 0) {
            //number is divisible by 5
            num = num / 3;
        }
        while (num % 5 == 0) {
            //number is divisible by 5
            num = num / 5;
        }
        return num == 1;
    }
}
