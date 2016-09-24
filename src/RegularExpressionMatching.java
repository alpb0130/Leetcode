/**
 * Created by alpb0130 on 9/11/16.
 * <p>
 * 10. Regular Expression Matching
 * <p>
 * Implement regular expression matching with support for '.' and '*'.
 * <p>
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * <p>
 * The matching should cover the entire input string (not partial).
 * <p>
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * <p>
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 */
public class RegularExpressionMatching {
    // DP.
    // Time: O(m * n)
    // Space: O(m * n)
    public boolean isMatch(String s, String p) {
        if (s == null && p == null) return true;
        if (s.length() == 0 && p.length() == 0) return true;
        int strLen = s.length(), reLen = p.length();
        boolean[][] dp = new boolean[strLen + 1][reLen + 1];
        // Initialize matrix
        dp[0][0] = true;
        // [i][0] should be false because non-empty string should not match any empty regex
        // Can be ignore because the matrix is initialize to false
        for (int i = 1; i < strLen + 1; i++) dp[i][0] = false;
        // dp[0][i] might be true if the regex starts with "a*"
        for (int i = 1; i < reLen + 1; i++) {
            // if encounter *, you can ignore the previous regex char
            // and dp[i][j] = dp[i][j - 2]
            if (p.charAt(i - 1) == '*' && i - 2 >= 0) dp[0][i] |= dp[0][i - 2] || dp[0][i - 1];
                // if not *, set to false
            else dp[0][i] = false;
        }
        // DP
        for (int i = 1; i < strLen + 1; i++) {
            for (int j = 1; j < reLen + 1; j++) {
                // If current regex char is matching letter or ., dp[i][j] = dp[i-1][j-1]
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                // If current regex char is * there would also be there case:
                // Case 1: does not match current char - dp[i][j] |= dp[i][j - 1]
                // Case 2: if * is not the start of regex and current char in str does not match "a*" like
                // regex, dp[i][j] = dp[i][j - 2]
                // Case 3: if * is not the start of regex and prev char in regex matches current char in
                // string or prev char in regex is ., dp[i][j] = dp[i][j - 1]
                if (p.charAt(j - 1) == '*') {
                    if (p.charAt(j - 2) != s.charAt(i - 1) && p.charAt(j - 2) != '.') {
                        dp[i][j] = dp[i][j - 2];
                    } else {
                        dp[i][j] = (dp[i][j - 1] || dp[i - 1][j] || dp[i][j - 2]);
                    }
                }
            }
        }
        return dp[strLen][reLen];
    }
}
