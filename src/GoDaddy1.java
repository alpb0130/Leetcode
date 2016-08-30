/**
 * Created by alpb0130 on 2/13/16.
 * <p>
 * String Compression
 * <p>
 * String限定由大小写字母组成
 * aaabbaa --> a3b2a2
 * aaabcdd --> a3bcd2
 */
public class GoDaddy1 {
    // Time complexity: O(n)
    public String compression(String str) {
        StringBuilder s = new StringBuilder();
        if (str == null || str.length() == 0) return s.toString();
        int count = 1;
        char c = str.charAt(0);
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != c) {
                s.append(c);
                if (count > 1)
                    s.append(count);
                c = str.charAt(i);
                count = 0;
            }
            count++;
        }
        s.append(c);
        if (count > 1)
            s.append(count);
        return s.toString();
    }
}
