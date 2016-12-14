/*
 * Reconstruct Itinerary
 * Tag: Depth-first Search
 * Tag: Graph
 */
import java.util.*;

public class ReconstructItinerary {
    // Eulerian path problem
    public List<String> findItinerary(String[][] tickets) {
        // Note: general: use proprity to specify the priority of traversal order
        Map<String, PriorityQueue<String>> g = new HashMap<String, PriorityQueue<String>>();
        for(String [] ticket : tickets) {
            if(!g.containsKey(ticket[0])) g.put(ticket[0], new PriorityQueue<String>());
            g.get(ticket[0]).add(ticket[1]);
        }
        
        List<String> res = new ArrayList<String>();
        dfs(g, res, "JFK");
        
        return res;
    }
    // get Eulerian path start from start-node
    private void dfs(Map<String, PriorityQueue<String>> g, List<String> res, String start) {
        // check and get available child nodes from the graph
        if(g.containsKey(start)) {
            while(g.get(start).size() > 0)
                // get and remove prioritized nodes
                dfs(g, res, g.get(start).poll());
        }
        res.add(0, start);    
    }
}
