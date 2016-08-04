/*
 * Pow(x, n)
 * Tag: Math
 * Tag: Binary Search
 */
import java.util.*;

public class PowXN {
    public double myPow(double x, int n) {
        // General: type: input type along mathematical definition
        // General: in order to avoid overflow issue in absolute conversion, we do not convert directly
        if(n == 0) return 1;
        double partRes = myPow(x, n / 2);
        // apply binary method!!
        double res = partRes * partRes;
        if((n & 1) != 0) res *= n > 0 ? x : (1/x);
        return res;
    }
}