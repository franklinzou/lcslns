/*
 * The Skyline Problem
 * Tag: Binary Indexed Tree
 * Tag: Segment Tree
 * Tag: Heap
 * Tag: Divide and Conquer
 */
import java.util.*;

class Tuple implements Comparable<Tuple> {
    // up = 1 indicates 
    int x, y, down;
    public Tuple(int x, int y, int down) {
        this.x = x;
        this.y = y;
        this.down = down;
    }
    // Tricky sort: we need to guarantee:
    // 1. up appears before down with the same x (so it will not drop directly followed by a up)
    // 2. if both up, larger value appears before smaller value (avoid continuous up)
    // 3. if both down, smaller value appears before larger value (avoid continuous down)
    public int compareTo(Tuple t) {
        // Note the order here:
        // TODO: analysis
        if(this.x != t.x) return this.x - t.x;
        else if(this.down != t.down) return this.down - t.down;
        else return this.down * this.y - t.down * t.y;
    }
}

public class TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
        // heap based method:
    	// basic idea: put y when there is a new building and take y away when building ends
    	// record if the maximum of existing ys changes
        int n = buildings.length, ind = 0;
        List<int[]> res = new ArrayList<int[]>();
        // store negative value of y to implement max-heap with min-heap
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        Tuple [] tuples = new Tuple[n * 2];
        for(int [] building : buildings) {
            tuples[ind ++] = new Tuple(building[0], building[2], -1);
            tuples[ind ++] = new Tuple(building[1], building[2], 1);
        }
        Arrays.sort(tuples);
        for(Tuple tuple : tuples) {
            if(tuple.down == -1) {
                if(pq.isEmpty() || tuple.y > -pq.peek()) {
                    //System.out.println((pq.isEmpty() ? "Empty" : pq.peek()) + " " + tuple.y);
                    res.add(new int [] {tuple.x, tuple.y});
                }
                pq.offer(-tuple.y);
            }
            else{
                pq.remove(-tuple.y);
                //System.out.println("remove " + tuple.y);
                if(pq.isEmpty() || -pq.peek() < tuple.y)
                    res.add(new int [] {tuple.x, pq.isEmpty() ? 0 : -pq.peek()});
            }
        }
        return res;
        // TODO: divide and conquer method
        // TODO: segment tree method
        // TODO: binary indexed tree method
    }
}
