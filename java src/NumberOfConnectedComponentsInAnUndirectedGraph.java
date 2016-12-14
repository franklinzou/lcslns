/*
 * Number of Connected Components in an Undirected Graph
 * Tag: Depth-first Search
 * Tag: Breadth-first Search
 * Tag: Union Find
 * Tag: Graph
 */
import java.util.*;

public class NumberOfConnectedComponentsInAnUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<List<Integer>>();
        for(int i = 0; i <= n - 1; i ++) adjList.add(new ArrayList<Integer>());
        for(int [] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        /*
        // DFS-based method
        int res = 0;
        boolean [] visited = new boolean[n]; // default false
        for(int i = 0; i <= n - 1; i++){
            if(!visited[i]){
                res ++;
                dfs(i, adjList, visited);
            }
        }
        return res;
        */
        // BFS-method
        int res = 0;
        boolean [] visited = new boolean[n];
        for(int i = 0; i <= n - 1; i ++) {
            if(!visited[i]) {
                res ++;
                Queue<Integer> q = new LinkedList<Integer>();
                visited[i] = true;
                q.offer(i);
                while(!q.isEmpty()) {
                    int s = q.poll();
                    for(int neigh : adjList.get(s)) {
                        if(!visited[neigh]) {
                            visited[neigh] = true;
                            q.offer(neigh);
                        }
                    }
                }
            }
        }
        return res;
        // TODO: union-find method
    }
    // set nodes connected to s to be visited
    private void dfs(int s, List<List<Integer>> adjList, boolean [] visited) {
        // set visited first to avoid revisit
        visited[s] = true;
        for(int u : adjList.get(s))
            if(!visited[u]) dfs(u, adjList, visited);
    }
}
