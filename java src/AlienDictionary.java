/*
 * Alien Dictionary
 * Tag: Topological Sort
 * Tag: Graph
 */
import java.util.*;

public class AlienDictionary {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> order = new HashMap<Character, Set<Character>>();
        Map<Character, Integer> in = new HashMap<Character, Integer>();
        // initialize in-degree mapping
        for(String word : words) {
            for(char c : word.toCharArray()) {
                if(!order.containsKey(c)) {
                    order.put(c, new HashSet<Character>());
                    in.put(c, 0);
                }
            }
        }
        // create order rules by comparing consecutive strings
        createOrder(words, order, in);
        
        // topological sort
        StringBuilder resBld = new StringBuilder();
        Queue<Character> q = new LinkedList<Character>();
        for(char c : in.keySet())
            if(in.get(c) == 0) q.offer(c);
        
        while(!q.isEmpty()) {
            char s = q.poll();
            resBld.append(s);
            for(char c : order.get(s)) {
                in.put(c, in.get(c) - 1);
                if(in.get(c) == 0) q.offer(c);
            }
        } 
        // check validity by examining if all elements has been in the list
        return resBld.length() < order.size() ? "" : resBld.toString();
    }
    
    private void createOrder(String[] words, Map<Character, Set<Character>> order, Map<Character, Integer> in) {
        int n = words.length;
        for(int i = 1; i <= n - 1; i ++) {
            String pre = words[i - 1], cur = words[i];
            int minLen = Math.min(pre.length(), cur.length());
            for(int j = 0; j <= minLen - 1; j ++)
                if(pre.charAt(j) != cur.charAt(j)) {
                    if(order.get(pre.charAt(j)).add(cur.charAt(j)))
                        in.put(cur.charAt(j), in.get(cur.charAt(j)) + 1);
                    break;
                }
        }
    }
}
