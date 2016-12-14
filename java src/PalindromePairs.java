/*
 * Palindrome Pairs
 * Tag: Hash Table
 * Tag: String
 * Tag: Trie
 */
import java.util.*;

public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
    	// map-based method
        /*
         * String A and B (A.len >= B.len) is a palindrome pair <=>
         * there exists i \in [0, len] such that A.sublen(0, i) is palindrome and A.sublen(i, len - i) = B.rev() (B + A)
         * OR A.sublen(0, i) = B.rev() and A.sublen(i, len - i) is palindrome (A + B)
         * Iterate over j to check if there exists i such that words[i].len <= words[j].len and there exists desirable 
         * k which makes words[i].rev() useful. A potential problem is a pair (A,B) with A.len = b.len will be added 
         * twice (A+B from A and A+B from B). So we only check i with words[i].len<words[j].len that makes A+B a palindrome.
         */
        Map<String, Integer> mp = new HashMap<String, Integer>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int i = 0; i <= words.length - 1; i ++) mp.put(words[i], i);
        for(int i = 0; i <= words.length - 1; i ++) {
            int len = words[i].length();
            for(int j = 0; j <= len; j ++) {
                String pre = words[i].substring(0, j), pro = words[i].substring(j);
                if(isPalin(pre)) {
                    String proRev = new StringBuilder(pro).reverse().toString();
                    // NOTE: type: distinct check needs to be explicit if we cannot guarantee map only contains
                    // previous elements
                    if(mp.containsKey(proRev) && mp.get(proRev) != i) res.add(Arrays.asList(mp.get(proRev), i));
                }
                if(j < len && isPalin(pro)) {
                    String preRev = new StringBuilder(pre).reverse().toString();
                    if(mp.containsKey(preRev) && mp.get(preRev) != i) res.add(Arrays.asList(i, mp.get(preRev)));
                }
            }
        }
        return res;
        // TODO: trie-based method
    }
    
    private boolean isPalin(String str) {
        int l = 0, r = str.length() - 1;
        while(l < r)
            if(str.charAt(l ++) != str.charAt(r --)) return false;
        return true;
    }
}
