/*
 * Insert Interval
 * Tag: Array
 * Tag: Sort
 */
import java.util.*;

public class InsertInterval {
    // can also do with in-place change that removes all overlapping interval with new interval and then
    // add new middle interval
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i = 0, n = intervals.size(), midS = newInterval.start, midE = newInterval.end;
        List<Interval> res = new ArrayList<Interval>();
        // just put left intervals
        for(;i <= n - 1 && intervals.get(i).end < newInterval.start; i ++) res.add(intervals.get(i));
        // for intervals that overlap with new interval, we compute s and e for the overlapped interval at runtime
        for(;i <= n - 1 && intervals.get(i).start <= newInterval.end; i ++) {
            midS = Math.min(midS, intervals.get(i).start);
            midE = Math.max(midE, intervals.get(i).end);
        }
        res.add(new Interval(midS, midE));
        // just put right intervals
        for(; i <= n - 1; i ++) res.add(intervals.get(i));
        return res;
    }
};
