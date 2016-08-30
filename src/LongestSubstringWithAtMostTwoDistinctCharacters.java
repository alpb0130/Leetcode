import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by alpb0130 on 1/29/16.
 * <p>
 * 159	Longest Substring with At Most Two Distinct Characters
 * <p>
 * Given a string S, find the length of the longest substring T that contains at most two distinct characters.
 * <p>
 * For example,
 * Given S = “eceba”,
 * T is “ece” which its length is 3.
 */
public class LongestSubstringWithAtMostTwoDistinctCharacters {
    // Time complxity: O(n) Space complexity: O
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null) return 0;
        if (s.length() <= 2) return s.length();
        HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
        int low = 0, high = 0;
        int maxLength = 0;
        while (high < s.length()) {
            if (hash.size() <= 2) {
                hash.put(s.charAt(high), high);
                high++;
            }
            if (hash.size() > 2) {
                int leftmost = s.length();
                for (int i : hash.values()) {
                    leftmost = Math.min(i, leftmost);
                }
                hash.remove(s.charAt(leftmost));
                low = leftmost + 1;
            }
            maxLength = Math.max(maxLength, high - low);
        }
        return maxLength;
    }
}
