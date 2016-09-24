/**
 * Created by alpb0130 on 1/18/16.
 * <p>
 * 9. Palindrome Number
 * <p>
 * Determine whether an integer is a palindrome. Do this without extra space.
 * click to show spoilers.
 * <p>
 * Some hints:
 * Could negative integers be palindromes? (ie, -1)
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 * <p>
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer",
 * you know that the reversed integer might overflow. How would you handle such case?
 * <p>
 * There is a more generic way of solving this problem.
 */
public class PalindromeNumber {
    // Reverse a integer. Time complexity: O(n). Space complexity: O(1)
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int z = x;
        long y = 0;
        while (z != 0) {
            y = y * 10 + z % 10;
            z /= 10;
        }
        return x == y;
    }

    // More efficient way. Check half of the number
    // Time complexity: O(n). Space complexity: O(1)
    public boolean isPalindrome1(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) return false;
        int y = 0;
        while (x > y) {
            y = y * 10 + x % 10;
            x /= 10;
        }
        return x == y || (y / 10 == x);
    }
}
