/**
 * Created by alpb0130 on 9/17/16.
 * <p>
 * 345. Reverse Vowels of a String  QuestionEditorial Solution
 * <p>
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * <p>
 * Example 1:
 * Given s = "hello", return "holle".
 * <p>
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 * <p>
 * Note:
 * The vowels does not include the letter "y".
 */
public class ReverseVowelsOfAString {
    // Two pointer.
    // Time: O(n)
    // Space: O(n)
    // Be careful about the set initialization and return value
    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1) return s;
        char[] strArr = s.toCharArray();
        int i = 0, j = s.length() - 1;
        /*Set<Character> set = new HashSet<Character>() {{
            add('a');
            add('e');
            add('i');
            add('o');
            add('u');
        }};*/
        /*Set<Character> set = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));*/
        while (true) {
            while (i < s.length() && "aeiouAEIOU".indexOf(s.charAt(i)) < 0) i++;
            while (j >= 0 && "aeiouAEIOU".indexOf(s.charAt(j)) < 0) j--;
            if (i >= j) break;
            swap(strArr, i, j);
            i++;
            j--;
        }
        return String.valueOf(strArr);
        // return new String(strArr);
    }

    public void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }
}
