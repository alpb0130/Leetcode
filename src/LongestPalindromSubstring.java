/**
 * Created by alpb0130 on 12/17/15.
 * <p>
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000,
 * and there exists one unique longest palindromic substring
 */
public class LongestPalindromSubstring {
    public String longestPalindrome(String s) {
        if (s == null) return null;
        int start = 0, end = 0;
        int l = s.length();
        int maxlen = 1;
        for (int i = 0; i < l; i++) {
            int left = i, right = i;
            while (left > -1 && right < l) {
                if (s.charAt(left) != s.charAt(right))
                    break;
                left--;
                right++;
            }
            if (maxlen < right - left - 1) {
                maxlen = right - left - 1;
                start = left + 1;
                end = right - 1;
            }
            left = i;
            right = i + 1;
            while (left > -1 && right < l) {
                if (s.charAt(left) != s.charAt(right))
                    break;
                left--;
                right++;
            }
            if (maxlen < right - left - 1) {
                maxlen = right - left - 1;
                start = left + 1;
                end = right - 1;
            }
        }
        return s.substring(start, end + 1);
    }
}
