/**
 * Created by alpb0130 on 2/13/16.
 * <p>
 * 91. Decode Ways
 * <p>
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * <p>
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 */
public class DecodeWays {
    // DP. Time complexity: O(n). Space complexity: O(n).
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i < s.length() + 1; i++) {
            if (i == 1 && s.charAt(i - 1) != '0') {
                dp[i] = 1;
            } else if (i > 1) {
                if (Integer.valueOf(s.substring(i - 1, i)) > 0) {
                    dp[i] += dp[i - 1];
                }
                if (Integer.valueOf(s.substring(i - 2, i)) <= 26 && Integer.valueOf(s.substring(i - 2, i)) >= 10) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[s.length()];
    }
}
