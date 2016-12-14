/*
 * Decode Ways
 * Tag: Dynamic Programming
 * Tag: String
 */
import java.util.*;

public class DecodeWays {
    /*
     * dp[i] indicates count for s[s..i]
     * dp[i] = dp[i-1] if s[i] is valid + dp[i-2] if s[i-1..i] is valid
     */    
    public int numDecodings(String s) {
        // can also use DFS method: TODO: consider relationship
        if(s.length() == 0) return 0;
        int res = s.charAt(0) == '0' ? 0 : 1, preRes = 1, n = s.length(); // invalid access value for preRes
        for(int i = 1; i <= n - 1; i++){
            int tmp = res;
            res = 0; // default answer for condition update
            if(s.charAt(i) != '0') res += tmp;
            if(s.charAt(i - 1) == '1' || (s.charAt(i - 1) == '2' && s.charAt(i) <= '6'))
                res += preRes;
            preRes = tmp;
        }
        return res;
    }
}