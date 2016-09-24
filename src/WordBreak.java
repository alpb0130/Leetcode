import java.util.Set;

/**
 * Created by alpb0130 on 9/15/16.
 * <p>
 * 139. Word Break
 * <p>
 * Given a string s and a dictionary of words dict, determine if
 * s can be segmented into a space-separated sequence of one or
 * more dictionary words.
 * <p>
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * <p>
 * Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {
    // DP.
    // Time: O(n^2)
    // Space: O(n)
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null) return false;
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j, i)) && dp[j]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
