/*
 * Super Pow
 * Tag: Math
 */
import java.util.*;

public class SuperPow {
    private final int mod = 1337;
    
    public int superPow(int a, int[] b) {
        // special judgement for blank array
        if(b.length == 0) return 1;
        return helper(a, b, b.length - 1);
    }
    /*
     * (a ^ 123456) % k = (a^123450 * a^6) % k 
     * = ((a^123450 % k) * (a^6 % k)) % k
     * = (((a ^ 12345) ^ 10) % k * a^6 % k) % k
     * stop when digit number is 1
     */
    private int helper(int a, int [] b, int e){
        if(e == 0) return smallPower(a, b[e]);
        return smallPower(helper(a, b, e - 1), 10) * smallPower(a, b[e]) % mod;
    }
    
    // calculate a^n % k, with ab % k = ((a % k) * (b % k))%k
    private int smallPower(int a, int n){
        int base = a % mod, res = 1;
        for(int i = 1; i <= n; i++) res = (res * base) % mod;
        return res;
    }
}