/**
 * Created by alpb0130 on 1/19/16.
 * <p>
 * Reverse Char Array
 */
public class ReverseCharArray {
    public void reverseArray(char[] charArray) {
        int l = charArray.length;
        if (l <= 1) return;
        reverse(charArray, 0, l - 1);

        int i = 0;
        while (charArray[i] == ' ')
            i++;
        int start = i, end = 0;
        for (; i < l; i++) {
            if (charArray[i] == ' ') {
                end = i - 1;
                reverse(charArray, start, end);
                while (i < l && charArray[i] == ' ')
                    i++;
                start = i;
            }
        }
        if (start < l) reverse(charArray, start, l - 1);
    }

    public void reverse(char[] charArray, int start, int end) {
        while (true) {
            if (start >= end) return;
            char c = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = c;
            start++;
            end--;
        }
    }
}
