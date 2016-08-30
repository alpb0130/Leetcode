import java.util.HashMap;

/**
 * Created by alpb0130 on 1/18/16.
 * <p>
 * 290. Word Pattern
 * <p>
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * Notes:
 * You may assume pattern contains only lowercase letters,
 * and str contains lowercase letters separated by a single space.
 */
public class WordPattern {
    // HashMap. Time complexity: O(n). Space complexity: O(k) + O(n) - SPLIT
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> hash = new HashMap<Character, String>();
        String[] strArray = str.split(" ");
        if (pattern.length() != strArray.length) return false;
        for (int i = 0; i < pattern.length(); i++) {
            if (hash.containsKey(pattern.charAt(i))) {
                if (!hash.get(pattern.charAt(i)).equals(strArray[i])) {
                    return false;
                }
            } else {
                // This is important. You need to concerned about the duplicate elements in Hash.
                // Different keys, different values.
                if (hash.containsValue(strArray[i])) {
                    return false;
                }
                hash.put(pattern.charAt(i), strArray[i]);
            }
        }
        return true;
    }
}
