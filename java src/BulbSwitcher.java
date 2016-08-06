/*
 * Rectangle Area
 * Tag: Math
 * Tag: Brainteaser
 */
import java.util.*;

public class BulbSwitcher {
    public int bulbSwitch(int n) {
        // undefined input
        if(n <= 0) return 0;
        // the number of POSITIVE integer i such that i^2 <= n
        int cnt = 0, i = 1;
        while(i * i <= n){
            cnt ++;
            i ++;
        }
        return cnt;        
    }
}