/*
 * Plus One
 * Tag: Math
 * Tag: Array
 */
import java.util.*;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        List<Integer> resList = new ArrayList<Integer>();
        int n = digits.length, carrier = 1, ind = n - 1;
        // tricky open condition, avoid repeating routine code
        while(ind >= 0 || carrier == 1){
            // special check here for validity of ind
            int newSum = (ind >= 0 ? digits[ind] : 0) + carrier;
            resList.add(0, newSum % 10);
            carrier = newSum / 10;
            ind --;
        }
        
        int [] res = new int[resList.size()];
        int resInd = 0;
        for(int val : resList) res[resInd++] = val;
        return res;
    }
}