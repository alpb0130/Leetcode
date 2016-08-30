/**
 * Created by alpb0130 on 1/29/16.
 * <p>
 * 14. Longest Common Prefix
 * <p>
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LongestCommonPrefix {
    // Time complexity: O(n * m). Space complexity: O(1)
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return new String();
        StringBuilder str = new StringBuilder();
        int index = 0;
        while (true) {
            char c;
            if (index < strs[0].length()) {
                c = strs[0].charAt(index);
            } else {
                return str.toString();
            }
            for (int i = 1; i < strs.length; i++) {
                if (index < strs[i].length() && c == strs[i].charAt(index)) {
                    continue;
                } else {
                    return str.toString();
                }
            }
            str.append(c);
            index++;
        }
    }
}
