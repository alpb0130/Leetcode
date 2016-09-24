/**
 * Created by alpb0130 on 9/18/16.
 * <p>
 * 344. Reverse String
 * <p>
 * Write a function that takes a string as input and returns the string reversed.
 * <p>
 * Example:
 * Given s = "hello", return "olleh".
 */
public class ReverseString {
    // Time: O(n)
    // Space: O(1)
    public String reverseString(String s) {
        if (s == null || s.length() == 0) return s;
        char[] strArr = s.toCharArray();
        int i = 0, j = strArr.length - 1;
        while (true) {
            swap(strArr, i, j);
            i++;
            j--;
            if (i >= j) break;
        }
        return new String(strArr);
    }

    public void swap(char[] array, int i, int j) {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
