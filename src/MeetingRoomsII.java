import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by alpb0130 on 9/24/16.
 * <p>
 * 253. Meeting Rooms II  QuestionEditorial Solution  My Submissions
 * Given an array of meeting time intervals consisting of start and end times
 * [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 * <p>
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return 2.
 */
public class MeetingRoomsII {
    // Time: O(n*logk)
    // Space: O(k)
    // Use min heap to store current end time of each room.
    // If current interval start time is smaller than the minimum end time,
    // create a new room (add end time to the heap)
    // Else, update the minimum end time
    // Return the size of heap
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>();
        for (Interval interval : intervals) {
            if (heap.size() == 0) {
                heap.offer(interval.end);
            } else {
                if (interval.start < heap.peek()) {
                    heap.offer(interval.end);
                } else {
                    heap.poll();
                    heap.offer(interval.end);
                }
            }
        }
        return heap.size();
    }
}
