import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by alpb0130 on 9/24/16.
 * <p>
 * 252. Meeting Rooms  QuestionEditorial Solution  My Submissions
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
 * <p>
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return false.
 */
public class MeetingRooms {
    // Time: O(nlogn)
    // Space: O(1)
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        if (intervals == null || intervals.length == 0) return true;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) return false;
        }
        return true;
    }
}
