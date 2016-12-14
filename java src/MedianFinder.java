/*
 * Find Median from Data Stream
 * Tag: Heap
 * Tag: Design
 */
import java.util.*;

public class MedianFinder {
    PriorityQueue<Integer> lq;
    PriorityQueue<Integer> rq;
    
    Comparator<Integer> cmp = new Comparator<Integer>() {
        public int compare(Integer a, Integer b) {
            return b - a;
        }
    };
    
    public MedianFinder() {
        lq = new PriorityQueue<Integer>(cmp);
        rq = new PriorityQueue<Integer>();
    }
    // Adds a number into the data structure.
    public void addNum(int num) {
        // guarantee any number in left queue <= number in right queue
        // and number in rq increases by 1
        lq.offer(num);
        rq.offer(lq.poll());
        // guarantee left queue is 1 or 0 elements more than right queue
        while(rq.size() > lq.size()) lq.offer(rq.poll());
    }

    // Returns the median of current data stream
    public double findMedian() {
        if(lq.size() == rq.size()) return (lq.peek() * 1.0 + rq.peek() * 1.0) / 2;
        else return lq.peek();
    }
    
};
