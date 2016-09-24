import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by alpb0130 on 9/23/16.
 * <p>
 * 56. Merge Intervals  QuestionEditorial Solution  My Submissions
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 */
public class MergeIntervals {
    // Time: O(nlogn), Space:O(1)
    // Sort the range first by the start element of interval
    // Record the max and min of current interval
    // If the start of next range is large then current max,
    // a new range get.
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ret = new ArrayList<Interval>();
        if (intervals == null || intervals.size() == 0) return ret;
        Comparator<Interval> c = new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        };
        Collections.sort(intervals, c);
        int min = intervals.get(0).start, max = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start > max) {
                Interval interval = new Interval(min, max);
                ret.add(interval);
                min = intervals.get(i).start;
                max = intervals.get(i).end;
            } else {
                min = Math.min(min, intervals.get(i).start);
                max = Math.max(max, intervals.get(i).end);
            }
        }
        Interval interval = new Interval(min, max);
        ret.add(interval);
        return ret;
    }
}
