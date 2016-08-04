/*
 * Repeated DNA Sequences
 * Tag: Bit Manipulation
 * Tag: Hash Table
 */
import java.util.*;

public class RepeatedDNASequences {
    public List<String> findRepeatedDnaSequences(String s) {
        // when possible character is limited, use int to represent a string
        Map<Integer, Integer> occur = new HashMap<Integer, Integer>();
        List<String> res = new ArrayList<String>();
        int n = s.length(), preInt = 0;
        for(int i = 0; i <= n - 1; i++){
        	// NOTE: use mask to take previous 20 bits
            preInt = ((preInt << 2) | getIntSym(s.charAt(i))) & 0xfffff;
            if(i >= 9){
                int occurTime = occur.containsKey(preInt) ? occur.get(preInt) : 0;
                // we only add string once to avoid duplicate
                if(occurTime == 1) res.add(s.substring(i - 9, i + 1));
                // update occur
                occur.put(preInt, occurTime + 1);
            }
        }
        return res;
    }
    
    private int getIntSym(char c){
        switch(c){
            case 'A': return 0;
            case 'T': return 1;
            case 'C': return 2;
            case 'G': return 3;
            default: return -1; // it should not be reached
        }
    }
}