import java.util.HashMap;
import java.util.Map;

/**
 * Created by alpb0130 on 1/18/16.
 * <p>
 * 205. Isomorphic Strings
 * <p>
 * Given two strings s and t, determine if they are isomorphic.
 * <p>
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * <p>
 * For example,
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 * <p>
 * Note:
 * You may assume both s and t have the same length.
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> hash = new HashMap<Character, Character>();
        for (int i = 0; i < s.length(); i++) {
            if (hash.containsKey(s.charAt(i))) {
                if (!hash.get(s.charAt(i)).equals(t.charAt(i))) {
                    return false;
                }
            } else {
                if (hash.containsValue(t.charAt(i))) {
                    return false;
                }
                hash.put(s.charAt(i), t.charAt(i));
            }
        }
        return true;
    }

    public boolean isIsomorphic1(String s1, String s2) {
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();

        for (Integer i = 0; i < s1.length(); i++) {

            if (m1.put(s1.charAt(i), i) != m2.put(s2.charAt(i), i)) {
                return false;
            }
        }
        return true;
    }
}
