/*
 * Group Anagrams
 * Tag: Hash Table
 * Tag: String
 */
import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Group each member in array with a property and use map to store list of members for a certain property
        Map<String, List<String>> mp = new HashMap<String, List<String>>();
        int n = strs.length;
        for(int i = 0; i <= n - 1; i ++) {
            char [] charArr = strs[i].toCharArray();
            Arrays.sort(charArr);
            String sortStr = new String(charArr);
            if(!mp.containsKey(sortStr)) mp.put(sortStr, new ArrayList<String>());
            mp.get(sortStr).add(strs[i]);
        }
        // create new ArrayList based on a List
        return new ArrayList<List<String>>(mp.values());
    }
}
