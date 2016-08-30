import jdk.nashorn.internal.runtime.ListAdapter;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by alpb0130 on 1/9/16.
 * <p>
 * 49. Group Anagrams
 * <p>
 * Given an array of strings, group anagrams together.
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * [
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note:
 * For the return value, each inner list's elements must follow the lexicographic order.
 * All inputs will be in lower-case.
 * <p>
 * Number of words: n. Average Length of word: m. Group of anagram: k.
 * Time complexity:  and
 * Space complexity: O(1) and
 */
public class GroupAnagram {
    // Correct method. Need to sort each word. (No repeated words exist)
    // O(nlogn + n * mlogm)  O(n)
    public List<List<String>> groupAnagrams1(String[] strs) {
        HashMap<String, List<String>> hash = new HashMap<String, List<String>>();
        Arrays.sort(strs);
        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            List<String> temp = hash.getOrDefault(sortedStr, new ArrayList<String>());
            temp.add(s);
            hash.put(sortedStr, temp);
        }
        return new ArrayList<List<String>>(hash.values());
    }

    // Without sort
    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, List<String>> hash = new HashMap<String, List<String>>();
        Arrays.sort(strs);
        for (String s : strs) {
            String key = getKey(s);
            List<String> temp = hash.getOrDefault(key, new ArrayList<String>());
            temp.add(s);
            hash.put(key, temp);
        }
        return new ArrayList<List<String>>(hash.values());
    }

    // Get key
    public String getKey(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        int[] array = new int[26];
        for (int i = 0; i < str.length(); i++) {
            array[str.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (array[i] != 0) {
                stringBuilder.append(array[i]);
                stringBuilder.append((char) ('a' + i));
            }
        }
        return stringBuilder.toString();
    }

    // Naive method. Visit every string and judge whether a string is the anagram of all the visited string.
    // O(nlogn + n * k * m)
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> llist = new ArrayList<List<String>>();
        if (strs.length == 0) return llist;
        Arrays.sort(strs);
        ArrayList<String> list = new ArrayList<String>();
        list.add(strs[0]);
        llist.add(list);
        for (int i = 0; i < strs.length; i++) {
            for (int j = 0; j < llist.size(); j++) {
                if (isAnagram(strs[i], llist.get(j).get(0))) {
                    llist.get(j).add(strs[i]);
                } else {
                    list = new ArrayList<String>();
                    list.add(strs[i]);
                    llist.add(list);
                }
            }
        }
        return llist;
    }

    public boolean isAnagram(String s, String t) {
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
