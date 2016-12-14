/*
 * Graph Valid Tree
 * Tag: Depth-first Search
 * Tag: Breadth-first Search
 * Tag: Union-find
 * Tag: Graph
 */
import java.util.*;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        /*
        // DFS method
        if(n == 0) return true; // special judgement to for start of DFS
        
        List<List<Integer>> g = new ArrayList<List<Integer>>();
        for(int i = 0; i <= n - 1; i ++) g.add(new ArrayList<Integer>());
        for(int [] edge : edges) {
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
        }
        boolean [] visited = new boolean[n];
        
        // All nodes are connected and there is no cycle connecting node 0 <=> G is a tree
        // -1 can be viewed as a dummy node
        if(!traverse(g, visited, 0)) return false;
        // check connectivity
        for(boolean rec : visited)
            if(!rec) return false;
        
        return true;
        */
        // BFS method
    	// special judgement because of initial element in queue
        if(n == 0) return true;
        
        List<List<Integer>> g = new ArrayList<List<Integer>>();
        for(int i = 0; i <= n - 1; i ++) g.add(new ArrayList<Integer>());
        for(int [] edge : edges) {
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
        }
        
        boolean [] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<Integer>();
        visited[0] = true;
        q.offer(0);
        while(!q.isEmpty()) {
            int s = q.poll();
            List<Integer> neighs = g.get(s);
            for(int neigh : neighs) {
                if(visited[neigh]) return false;
                // General: type: remove backward edge
                g.get(neigh).remove(new Integer(s));
                visited[neigh] = true;
                q.offer(neigh);
            }
        }
        
        for(boolean rec : visited)
            if(!rec) return false;

        return true;
        // TODO: union-find method
    }
    
    // check if there exists a one-edge-one-use-cycle containing ind in g and 
    private boolean traverse(List<List<Integer>> g, boolean [] visited, int ind) {
        // set visited to be true before branching
    	visited[ind] = true;
        
        List<Integer> neighs = new ArrayList<Integer>(g.get(ind));
        for(int neigh : neighs) {
            if(visited[neigh]) return false;
            // General: type: Remove backwards edge to guarantee OEOU cycle
            g.get(neigh).remove(new Integer(ind));
            if(!traverse(g, visited, neigh)) return false;
        }
        
        return true;
    }
}
