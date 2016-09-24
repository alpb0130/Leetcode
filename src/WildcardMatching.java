/**
 * Created by alpb0130 on 9/10/16.
 * <p>
 * 44. Wildcard Matching
 * <p>
 * mplement wildcard pattern matching with support for '?' and '*'.
 * <p>
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
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
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 */
public class WildcardMatching {
    // 2D-DP.
    // Time: O(n*m)
    // Space: O(n*m)
    public boolean isMatch(String s, String p) {
        if (s == null && p == null) return true;
        if (s.length() == 0 && p.length() == 0) return true;
        int strLen = s.length(), reLen = p.length();
        boolean[][] dp = new boolean[strLen + 1][reLen + 1];
        // Initialize.
        // [0][0] should be true because empty string should match empty regex.
        dp[0][0] = true;
        // [i][0] should be false because non-empty string should not match any empty regex
        // Can be ignore because the matrix is initialize to false
        for (int i = 1; i < strLen + 1; i++) dp[i][0] = false;
        // dp[0][i] might be true if the regex starts with "*"
        for (int i = 1; i < reLen + 1; i++) {
            dp[0][i] = (p.charAt(i - 1) == '*') && dp[0][i - 1];
        }
        // DP
        for (int i = 1; i < strLen + 1; i++) {
            for (int j = 1; j < reLen + 1; j++) {
                // If current regex char is matching letter or ?, dp[i][j] = dp[i-1][j-1]
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                    dp[i][j] = dp[i - 1][j - 1];
                // If current regex char is *, there would be three cases:
                // Case 1: * matches current char in string but do not match prev char - dp[i][j] |= dp[i - 1][j - 1]
                // Case 2: * matches current char in string and prev char - dp[i][j] |= dp[i - 1][j]
                // Case 3: * does not match current char - dp[i][j] |= dp[i][j - 1]
                if (p.charAt(j - 1) == '*')
                    dp[i][j] |= dp[i][j - 1] || dp[i - 1][j] || dp[i - 1][j - 1];
            }
        }
        return dp[strLen][reLen];
    }
}
