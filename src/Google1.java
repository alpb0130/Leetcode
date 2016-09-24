/**
 * Created by alpb0130 on 9/13/16.
 * <p>
 * You are given an integer x. You mush choose two adjacent digits
 * and replace them with the larger of these two digits.
 * <p>
 * For example, from the integer X = 233614, you can obtain:
 * <p>
 * 33614 (by replacing 23 with 3)
 * 23614 (by replacing 33 with 3 or 36 with 6)
 * 23364 ((by replacing 61 with 6 or 14 with 4)
 * <p>
 * You want to find the smallest number that can be obtained from x by
 * replacing two adjacent digits with the larger of the two.
 */
public class Google1 {
    public static int solution(int x) {
        if (x < 10 && x > -10) return x;
        int pre = x % 10;
        int cur = 0;
        int low = 0;
        int factor = 1;
        x /= 10;
        int min = Integer.MAX_VALUE;
        while (x != 0) {
            cur = x % 10;
            x /= 10;
            min = Math.min(min, (x * 10 + Math.max(cur, pre)) * factor + low);
            low = low + pre * factor;
            factor *= 10;
            pre = cur;
        }
        return min;
    }
}
