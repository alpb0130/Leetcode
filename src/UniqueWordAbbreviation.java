import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by alpb0130 on 9/17/16.
 * <p>
 * 288. Unique Word Abbreviation  QuestionEditorial Solution  My Submissions
 * <p>
 * An abbreviation of a word follows the form <first letter><number><last letter>.
 * Below are some examples of word abbreviations:
 * <p>
 * a) it                      --> it    (no abbreviation)
 * 1
 * b) d|o|g                   --> d1g
 * <p>
 * 1    1  1
 * 1---5----0----5--8
 * c) i|nternationalizatio|n  --> i18n
 * <p>
 * 1
 * 1---5----0
 * d) l|ocalizatio|n          --> l10n
 * <p>
 * Assume you have a dictionary and given a word, find whether
 * its abbreviation is unique in the dictionary. A word's abbreviation
 * is unique if no other word from the dictionary has the same abbreviation.
 * <p>
 * Example:
 * Given dictionary = [ "deer", "door", "cake", "card" ]
 * isUnique("dear") -> false
 * isUnique("cart") -> true
 * isUnique("cane") -> false
 * isUnique("make") -> true
 */
public class UniqueWordAbbreviation {
    // A better method is to use Map<String, String> and add "" if there are more than one word in the dict
    // has the same abbr
    // Be careful about the definition of unique.
    // Time: O(1)
    // Space: O(n)
    Map<String, Set<String>> map = new HashMap<String, Set<String>>();

    public UniqueWordAbbreviation(String[] dictionary) {
        for (String str : dictionary) {
            String temp = getKey(str);
            Set<String> set = map.containsKey(temp) ? map.get(temp) : new HashSet<String>();
            set.add(str);
            map.put(temp, set);
        }
    }

    public boolean isUnique(String word) {
        String str = getKey(word);
        Set<String> set = map.get(str.toString());
        return (set == null || (set.size() == 1 && set.contains(word)));
    }

    public String getKey(String str) {
        if (str.length() <= 2) return str;
        else return str.charAt(0) + Integer.toString(str.length() - 2) + str.charAt(str.length() - 1);
    }
}
