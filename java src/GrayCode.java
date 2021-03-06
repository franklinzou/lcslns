/*
 * Gray Code
 * Tag: Backtracking
 */
import java.util.*;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        // NOTE: general: sum model, default answer
        res.add(0);
        int adder = 1;
        for(int i = 1; i <= n; i++){
            int s = res.size();
            for(int j = s - 1; j >= 0; j --) res.add(res.get(j) | adder);
            adder <<= 1;
        }
        return res;
    }
}