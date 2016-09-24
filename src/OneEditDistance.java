/**
 * Created by alpb0130 on 9/14/16.
 * <p>
 * 161. One Edit Distance
 * <p>
 * Given two strings S and T, determine if they are both one edit distance apart.
 */
public class OneEditDistance {
    // Much cleaner version
    // After you find the first different char in the two string, you
    // don not need to compare the remaining substring one by one. Directly
    // comparing the remaining substring would be ok.
    // Time: O(n)
    // Space: O(1)
    public boolean isOneEditDistance(String s, String t) {
        if ((s == null && t == null) || (s.equals(t))) return false;
        if (Math.abs(s.length() - t.length()) > 1) return false;
        for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.length() == t.length())
                    return s.substring(i + 1).equals(t.substring(i + 1));
                else if (s.length() < t.length())
                    return s.substring(i).equals(t.substring(i + 1));
                else
                    return s.substring(i + 1).equals(t.substring(i));
            }
        }
        return true;
    }

    // My first version.
    // Time: O(n)
    // Space: O(1)

    public boolean isOneEditDistance1(String s, String t) {
        if ((s == null && t == null) || (s.equals(t))) return false;
        int len1 = s.length(), len2 = t.length();
        if (Math.abs(len1 - len2) > 1) return false;
        boolean flag = (len1 == len2);
        boolean hasEdit = false;
        int i = 0, j = 0;
        while (i < len1 || j < len2) {
            if (i == len1 || j == len2) {
                if (hasEdit) return false;
                else break;
            }
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
                continue;
            }
            if (!hasEdit) {
                if (flag) {
                    i++;
                    j++;
                } else {
                    if (len1 < len2) j++;
                    else i++;
                }
                hasEdit = true;
            } else {
                return false;
            }
        }
        return true;
    }
}
