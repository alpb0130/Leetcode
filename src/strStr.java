/**
 * Created by alpb0130 on 1/28/16.
 * <p>
 * 28. Implement strStr()
 * <p>
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * Subscribe to see which companies asked this question
 */
public class strStr {
    // Brute force. Time complexity: O(n * k). Space complexity: O(1)
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
            }
        }
    }

    // Straight-forward method
    public int strStr1(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        for (int i = 0; i < haystack.length(); i++) {
            int j;
            boolean flag = true;
            for (j = 0; j < needle.length(); j++) {
                if (i + j == haystack.length()) return -1;
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    flag = false;
                    break;
                }
            }
            if (flag) return i;
        }
        if (needle.length() == 0)
            return 0;
        return -1;
    }
}
