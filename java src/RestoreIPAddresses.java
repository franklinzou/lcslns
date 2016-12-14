/*
 * Restore IP Addresses
 * Tag: Backtracking
 * Tag: String
 */
import java.util.*;

public class RestoreIPAddresses {
	/* 
	 * TFP with pruning
	 * TFP(len, pre, k) = I + TFP(len, I, k-1), I \in [pre, len - 1], k >= 1
	 * TFP(len, pre, 0) = []
	 * Basic idea is to find TFP and check if each TFP is FP
	 * Simple pruning is used for efficiency
	 */
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> res = new ArrayList<String>();
        for(int i = 0; i <= 2 && len - 1 - i >= 3; i ++){
            String s1 = s.substring(0, i + 1);
            if(!valid(s1)) continue; // pruning
            // pruning is used by setting lower and upper bound of j
            for(int j = i + 1; j <= i + 3 && len - 1 - j >= 2; j ++){
                String s2 = s.substring(i + 1, j + 1);
                if(!valid(s2)) continue;
                for(int k = j + 1; k <= j + 3 && len - 1 - k >= 1; k ++){
                    String s3 = s.substring(j + 1, k + 1);
                    String s4 = s.substring(k + 1, len);
                    if(!valid(s3) || !valid(s4)) continue;
                    
                    res.add(s1 + "." + s2 + "." + s3 + "." + s4);
                }
            }
        }
        return res;
    }
    
    private boolean valid(String checkee) {
        if(checkee.charAt(0) == '0' && checkee.length() > 1) return false;
        // NOTE: general: parseInt may cause overflow
        return checkee.length() <=3 && Integer.parseInt(checkee) <= 255;
    }
}