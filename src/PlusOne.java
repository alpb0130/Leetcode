/**
 * Created by alpb0130 on 1/3/16.
 * <p>
 * 66. Plus One
 * <p>
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 * <p>
 * Time Complexity: O(n)
 *
 * PS: When the number is 99...999, you don't new to copy every digits to the new array.
 * Because the new number is 100...000, consider the most significant number only.
 */
public class PlusOne {
    // Much clearer method
    // Time: O(n)
    // Space: O(1)
    public int[] plusOne1(int[] digits) {
        if (digits.length == 0) return digits;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                break;
            }
            digits[i] = 0;
        }
        if (digits[0] == 0) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            return newDigits;
        }
        return digits;
    }

    public int[] plusOne(int[] digits) {
        if (digits.length == 0) return digits;
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int d = digits[i] + carry;
            digits[i] = d % 10;
            carry = d / 10;
            if (carry == 0) return digits;
        }
        if (carry == 1) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = carry;
            return newDigits;
        }
        return digits;
    }
}
