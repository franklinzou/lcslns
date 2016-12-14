/*
 * Minimum Height Trees
 * Tag: Breadth-first Search
 * Tag: Graph
 */
import java.util.*;

public class MinimumHeightTrees {
    /* 
     * Basic idea: remove nodes at edge sequentially, it is simple to prove that any node 
     * not taken in the end is not optimal. So we basically do a topological sort based on
     * indirected edges
     */

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<Integer>();
        // Special judgement 
        if(n == 1) {
            res.add(0);
            return res;
        }
        int [] deg = new int[n], dist = new int[n];
        List<List<Integer>> g = new ArrayList<List<Integer>>();
        for(int i = 0; i <= n - 1; i ++) g.add(new ArrayList<Integer>());
        for(int [] edge : edges) {
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
            deg[edge[0]] ++;
            deg[edge[1]] ++;
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i <= n - 1; i ++) {
            if(deg[i] == 1) {
                dist[i] = 1;
                q.offer(i);
            }
        }
        int curDist = 1;
        while(!q.isEmpty()) {
            // Tricky here, and problem will happen if we increment it at the end of the loop
            curDist ++;            
            int qSize = q.size();
            for(int k = 1; k <= qSize; k ++) {
                int s = q.poll();
                for(int neigh : g.get(s)) {
                    if(deg[neigh] != 1 && -- deg[neigh] == 1) {
                        dist[neigh] = curDist;
                        q.offer(neigh);
                    }
                }
            }
        }
        
        for(int i = 0; i <= n - 1; i ++)
            if(dist[i] == curDist - 1) res.add(i);
        return res;    
    }
}
