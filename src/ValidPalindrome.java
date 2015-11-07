/**
 * Created by alpb0130 on 10/25/15.
 * <p>
 * Valid Palindrome
 * <p>
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Time Complexity: O (n)
 * Space Complexity: O (0)
 *
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return true;
        }
        s = s.toLowerCase();
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            while (i < s.length() && !Character.isLetter(s.charAt(i)) && !Character.isDigit(s.charAt(i))) i++;
            while (j > 0 && !Character.isLetter(s.charAt(j)) && !Character.isDigit(s.charAt(j)) ) j--;
            if (i < s.length() && j >= 0 && s.charAt(i) - s.charAt(j) != 0) return false;
        }
        return true;
    }
}
