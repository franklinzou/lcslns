/*
 * Course Schedule II
 * Tag: Depth-first Search
 * Tag: Breadth-first Search
 * Topological Sort
 * Tag: Graph
 */
import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [] res = new int[numCourses], in = new int[numCourses];
        int ind = 0;
        List<List<Integer>> g = new ArrayList<List<Integer>>();
        for(int i = 0; i <= numCourses - 1; i ++) g.add(new ArrayList<Integer>());
        for(int [] preq : prerequisites) {
            g.get(preq[1]).add(preq[0]);
            in[preq[0]] ++;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i <= numCourses - 1; i ++)
            if(in[i] == 0) q.offer(i);
                
        while(!q.isEmpty()) {
            int s = q.poll();
            res[ind ++] = s;
            for(int child : g.get(s)) {
                in[child] --;
                if(in[child] == 0) q.offer(child);
            }
        }
        
        return ind < numCourses ? new int[0] : res;
    }
}
