/**
 * Created by alpb0130 on 9/14/16.
 * <p>
 * 72. Edit Distance
 * <p>
 * Given two words word1 and word2, find the minimum number of
 * steps required to convert word1 to word2. (each operation is
 * counted as 1 step.)
 * <p>
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 */
public class EditDistance {
    // DP
    // Time: O(m * n)
    // Space: O(m * n)
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i < len1 + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < len2 + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                // delete or insert
                dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                // if char at i equals to char at j, dp[i][j] = dp[i - 1][j - 1]
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                    // else replace
                else dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
            }
        }
        return dp[len1][len2];
    }

    // DP
    // Time: O(m * n)
    // Space: O(n)
    public int minDistance1(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[] dp = new int[len2 + 1];
        // Use pre to store dp[i - 1][j - 1]
        int pre = 0;
        int cur = 0;
        for (int i = 0; i < len2 + 1; i++) dp[i] = i;
        for (int i = 1; i < len1 + 1; i++) {
            pre = dp[0];
            dp[0] = i;
            for (int j = 1; j < len2 + 1; j++) {
                cur = Math.min(dp[j - 1], dp[j]) + 1;
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) cur = Math.min(cur, pre);
                else cur = Math.min(cur, pre + 1);
                pre = dp[j];
                dp[j] = cur;
            }
        }
        return dp[len2];
    }
}
