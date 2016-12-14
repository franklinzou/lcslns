/*
 * Meeting Rooms II
 * Tag: Heap
 * Tag: Greedy
 * Tag: Sort
 */
import java.util.*;

public class MeetingRoomsII {
    public int minMeetingRooms(Interval[] intervals) {
        // sort meetings by start time. Each time check if there is an existing room that can accomodate
        // the new meeting. If yes, put the meeting in the room; otherwise, create a new room for the meeting.
        // Method to check existence uses priority to find most likely room (with earliest end time). Easy to 
        // show there exists FP using this room if there is plan the new meeting is put elsewhere. (by simply
        // swapping the latter meetings of each room).
        Comparator<Interval> cmp = new Comparator<Interval>() {
            public int compare(Interval itv1, Interval itv2) {
                return itv1.start - itv2.start;
            }
        }; 
        // store ending time of each room
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        Arrays.sort(intervals, cmp);
        for(Interval itv : intervals) {
            if(pq.isEmpty() || pq.peek() > itv.start) pq.offer(itv.end);
            else {
                pq.poll();
                pq.offer(itv.end);
            }
        }
        return pq.size();
    }
};
