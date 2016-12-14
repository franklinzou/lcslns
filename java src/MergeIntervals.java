/*
 * Merge Intervals
 * Tag: Array
 * Tag: Sort
 */
import java.util.*;

public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<Interval>();
        int n = intervals.size();
        // NOTE: general: initial value with first element. blank array check is necessary
        if(n == 0) return res;
        Comparator<Interval> cmp = new Comparator<Interval>() {
            public int compare(Interval itv1, Interval itv2) {
                return itv1.start - itv2.start;
            }
        };
        
        Collections.sort(intervals, cmp);
        int s = intervals.get(0).start, e = intervals.get(0).end;
        for(int i = 1; i <= n - 1; i ++) {
            Interval cur = intervals.get(i);
            if(cur.start <= e) {
                if(cur.end > e) e = cur.end;
            }
            else {
                // it is easy to show current interval cannot get extended, so we put it into list
                res.add(new Interval(s, e));
                s = cur.start;
                e = cur.end;
            }
        }
        
        // NOTE: general: later trigger problem: remember to put the last interval
        res.add(new Interval(s, e));
        return res;
    }
};
