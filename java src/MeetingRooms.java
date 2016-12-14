/*
 * Meeting Rooms
 * Tag: Sort
 */
import java.util.*;

public class MeetingRooms {
    public boolean canAttendMeetings(Interval[] intervals) {
        Comparator<Interval> cmp = new Comparator<Interval>() {
            public int compare(Interval itv1 ,Interval itv2) {
                return itv1.start - itv2.start;
            }
        };
            
        Arrays.sort(intervals, cmp);       
        int preEnd = Integer.MIN_VALUE;
        for(Interval itv : intervals) {
            if(itv.start < preEnd) return false;
            preEnd = itv.end;
        }
        return true;
    }
};
