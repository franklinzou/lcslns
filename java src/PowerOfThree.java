/*
 * PowerOfThree
 * Tag: Math
 */
import java.util.*;

public class PowerOfThree {
    public boolean isPowerOfThree(int n) {
        // actually log_3(n)
        double logRes = Math.log10(n) / Math.log10(3);
        return logRes == (int)logRes;        
    }
}