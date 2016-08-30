import java.util.HashMap;
import java.util.Map;

/**
 * Created by alpb0130 on 10/25/15.
 * <p>
 * Valid Anagram
 * <p>
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * <p>
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * <p>
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 * <p>
 * Time Complexity: O (n)
 * Space Complexity: O (1) (hashmap is of constant size)
 */
public class ValidAnagram {
    // Hashmap
    public boolean isAnagram(String s, String t) {
        if (s == null && t == null) return true;
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> str = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (str.containsKey(s.charAt(i))) {
                str.put(s.charAt(i), str.get(s.charAt(i)) + 1);
            } else {
                str.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            if (str.containsKey(t.charAt(i))) {
                str.put(t.charAt(i), str.get(t.charAt(i)) - 1);
            } else {
                return false;
            }
        }
        for (Map.Entry<Character, Integer> entry : str.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }
        return true;
    }

    // Array.
    public boolean isAnagram1(String s, String t) {
        int[] charsMap = new int['z' - 'a' + 1];
        for (char c : s.toCharArray()) {
            int pos = c - 'a';
            charsMap[pos]++;
        }
        for (char c : t.toCharArray()) {
            int pos = c - 'a';
            charsMap[pos]--;
        }
        for (int count : charsMap) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
