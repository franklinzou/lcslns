/*
 * Count Primes
 * Tag: Math
 * Tag: Hash Table
 */
import java.util.*;

public class CountPrimes {
    public int countPrimes(int n) {
        // General: type: special case negative, 0, 1. results are 0, merged
        if(n <= 1) return 0;
        //notPrime[i] indicates whether i is a prime
        boolean [] notPrime = new boolean[n + 1];
        int [] primes = new int[n];
        int cnt = 0;
        for(int i = 2; i <= n - 1; i ++){
            if(!notPrime[i]) primes[cnt++] = i;
            for(int j = 0; j <= cnt - 1 && (long)i * primes[j] <= n; j++){
                notPrime[i * primes[j]] = true;
                if(i % primes[j] == 0) break;
            }
        }
        return cnt;
    }
}