/*
 * Isomorphic Strings
 * Tag: Hash Table
 */
import java.util.*;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        // check if there exists a one-one-mapping that transfer s to t
        int [] s2t = new int[255], t2s = new int[255];
        int len = s.length();
        for(int i = 0; i <= len - 1; i ++) {
            int sInt = s.charAt(i), tInt = t.charAt(i);
            // Note: type: array simulation, use 0 to define simulate non-key state
            if((s2t[sInt] != 0 && s2t[sInt] != tInt) || (t2s[tInt] != 0 && t2s[tInt] != sInt))
                return false;
            s2t[sInt] = tInt;
            t2s[tInt] = sInt;
        }
        return true;
    }
}
