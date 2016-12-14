/*
 * Course Schedule
 * Tag: Depth-first Search
 * Tag: Breadth-first Search
 * Topological Sort
 * Tag: Graph
 */
import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> g = new ArrayList<List<Integer>>();
        int [] in = new int[numCourses];
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
            for(int child : g.get(s)) {
                in[child] --;
                if(in[child] == 0) q.offer(child);
            }
        }
        for(int i = 0; i <= numCourses - 1; i ++)
            if(in[i] != 0) return false;
            
        return true;    
    }
}
