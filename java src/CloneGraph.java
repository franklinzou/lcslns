/*
 * Clone Graph
 * Tag: Depth-first Search
 * Tag: Breadth-first Search
 * Tag: Graph
 */
import java.util.*;

public class CloneGraph {
    private Map<Integer, UndirectedGraphNode> mp = new HashMap<Integer, UndirectedGraphNode>();
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        /*
        // DFS method
        // Special judgement
        if(node == null) return null;
        // if a mapping has already been created, return the counterpart directly
        if(mp.containsKey(node.label)) return mp.get(node.label);
        // create new node for original node if there is no mapping
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        mp.put(node.label, newNode); // set the mapping
        
        for(UndirectedGraphNode neigh : node.neighbors)
            newNode.neighbors.add(cloneGraph(neigh));
        
        return newNode;
        */
        // BFS method
        if(node == null) return null; // special judgement for first element in queue
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        mp.put(node.label, new UndirectedGraphNode(node.label));
        q.offer(node);
        while(!q.isEmpty()) {
            UndirectedGraphNode s = q.poll();
            UndirectedGraphNode sCounter = mp.get(s.label);
            for(UndirectedGraphNode neigh : s.neighbors) {
                if(!mp.containsKey(neigh.label)) {
                    // Use whether a mapping is established to replace visited check
                    mp.put(neigh.label, new UndirectedGraphNode(neigh.label));
                    q.offer(neigh);
                }
                sCounter.neighbors.add(mp.get(neigh.label));
            }
        }
        return mp.get(node.label);
    }
}
