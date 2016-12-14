/*
 * Word Pattern
 * Tag: Hash Table
 */
import java.util.*;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        // check if there exists a one-one-mapping that transfers pattern to str
        // two maps indicate constraints of one-one-mapping so far
        Map<Character, String> c2s = new HashMap<Character, String>();
        Map<String, Character> s2c = new HashMap<String, Character>();
        String [] sArr = str.split(" ");
        if(pattern.length() != sArr.length) return false;
        int len = pattern.length();
        for(int i = 0; i <= len - 1; i ++){
            char c = pattern.charAt(i);
            String s = sArr[i];
            // For a given (c, s) pair, we need result to contain two mappings (c->s and s->c), check if 
            // mapping from c, s exist and map to different targets (which violates one-one mapping)
            if((c2s.containsKey(c) && !c2s.get(c).equals(s)) || (s2c.containsKey(s) && s2c.get(s) != c))
                return false;
            if(!c2s.containsKey(c)){
                c2s.put(c, s);
                s2c.put(s, c);
            }
        }
        
        return true;
    }
}
