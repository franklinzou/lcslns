/*
 * Sort Transformed Array
 * Tag: Math
 * Tag: Two Pointers
 */
import java.util.*;

public class SortTransformedArray {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int factor = a > 0 ? -1 : 1, len = nums.length;
        int l = 0, r = len - 1;
        int ind = a > 0 ? len - 1: 0, indAdder = factor;
        int [] res = new int[len];
        while(l <= r){
            int lRes = cal(nums[l], a, b, c);
            int rRes = cal(nums[r], a, b, c);
            if(lRes * factor < rRes * factor){
                res[ind] = lRes;
                l++;
            }
            else{
                res[ind] = rRes;
                r--;
            }
            ind += indAdder;
        }
        return res;
    }
    
    private int cal(int x, int a, int b, int c){
        return a * x * x + b * x + c;
    }
}