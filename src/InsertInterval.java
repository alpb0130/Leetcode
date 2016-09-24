import java.util.ArrayList;
import java.util.List;

/**
 * Created by alpb0130 on 9/23/16.
 * <p>
 * 57. Insert Interval
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * <p>
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * <p>
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * <p>
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval {
    // Time: O(nlogn). Space: O(1)
    // Traverse the array.
    // If the start of the interval is larger than current max, insert directly.
    // If the end of the interval is smaller than current min, insert directly.
    // Else update min and max
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ret = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) {
            ret.add(newInterval);
            return ret;
        }
        if (newInterval == null) return intervals;
        int min = newInterval.start, max = newInterval.end;
        boolean flag = false;
        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {
                ret.add(interval);
            } else if (interval.start > newInterval.end) {
                if (!flag) {
                    ret.add(new Interval(min, max));
                    flag = true;
                }
                ret.add(interval);
            } else {
                min = Math.min(min, interval.start);
                max = Math.max(max, interval.end);
            }
        }
        if (!flag) ret.add(new Interval(min, max));
        return ret;
    }
}
