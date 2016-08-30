/**
 * Created by alpb0130 on 1/7/16.
 *
 * 275. H-Index II My Submissions Question
 *
 * Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
 * Hint:
 * Expected runtime complexity is in O(log n) and the input is sorted.
 *
 * Time complexity: O(logn)
 * Space complexity: O(1)
 */
public class HIndexII {
    public int hIndex(int[] citations) {
        int l = citations.length;
        int lower = 0, upper = citations.length - 1;
        int ret = 0;
        while (true) {
            if (lower > upper) break;
            int mid = (lower + upper) / 2;
            if (citations[mid] >= l - mid) {
                ret = l - mid;
                upper = mid - 1;
            } else {
                lower = mid + 1;
            }
        }
        return ret;
    }
}
