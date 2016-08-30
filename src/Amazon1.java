import java.util.HashMap;

/**
 * Created by alpb0130 on 1/19/16.
 *
 * Find the first non-repeat character in a string
 */
public class Amazon1 {
    // Use an array. Time complexity: O(n). Space complexity: O(k).
    public char solution(String str) {
        int[] count = new int[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i) - 'a'] == 1)
                return str.charAt(i);
        }
        return '-';
    }

    // HashMap.
    public char solution2(String str) {
        HashMap<Character, Integer> hash = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (hash.containsKey(c)) {
                hash.put(c, hash.get(c) + 1);
            } else {
                hash.put(c, 1);
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (hash.get(c) == 1) {
                return c;
            }
        }
        return '-';
    }
}

