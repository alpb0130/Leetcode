/**
 * Created by alpb0130 on 9/6/16.
 *
 * 3个string，判断是否存在其中一个是另外两个merge的结果
 */
public class VMware5 {
    public boolean isMerge(String a, String b, String c) {
        int i = 0, j = 0, k = 0;
        while (k < c.length()) {
            if (i < a.length() && c.charAt(k) == a.charAt(i)) {k++;i++;continue;}
            if (j < b.length() && c.charAt(k) == b.charAt(j)) {k++;j++;continue;}
            return false;
        }
        return true;
    }
}
