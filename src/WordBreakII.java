import java.util.*;

/**
 * Created by alpb0130 on 9/15/16.
 * <p>
 * 140. Word Break II
 * <p>
 * Given a string s and a dictionary of words dict, add spaces
 * in s to construct a sentence where each word is a valid dictionary word.
 * <p>
 * Return all such possible sentences.
 * <p>
 * For example, given
 * <p>
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * <p>
 * A solution is ["cats and dog", "cat sand dog"].
 */
public class WordBreakII {
    // DP and backtracking
    // Time: O()
    // Space: O()
    // Use a map the store the result of strings that already has been dealt
    Map<String, List<String>> map = new HashMap<String, List<String>>();

    // Backtracking and recursive (DFS)
    // From end to start
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if (map.containsKey(s)) return map.get(s);
        List<String> ret = new ArrayList<String>();
        // Corner case
        if (s == null) return ret;
        if (s.length() == 0) {
            ret.add("");
            return ret;
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            String str = s.substring(i, s.length());
            if (wordDict.contains(str)) {
                if (i == 0) ret.add(str);
                else {
                    List<String> list = wordBreak(s.substring(0, i), wordDict);
                    for (String string : list) {
                        ret.add(string + " " + str);
                    }
                }

            }
        }
        // Add current mapping
        map.put(s, ret);
        return ret;
    }

    // DP, Backtracking and recursive (DFS)
    // From start to end
    public List<String> wordBreak1(String s, Set<String> wordDict) {
        if (map.containsKey(s)) return map.get(s);
        List<String> ret = new ArrayList<String>();
        if (s == null) return ret;
        if (s.isEmpty()) {
            ret.add("");
            return ret;
        }
        for (String str : wordDict) {
            if (s.startsWith(str)) {
                List<String> list = wordBreak1(s.substring(str.length()), wordDict);
                for (String string : list) {
                    ret.add(str + (string.isEmpty() ? "" : " ") + string);
                }
            }
        }
        map.put(s, ret);
        return ret;
    }
}
