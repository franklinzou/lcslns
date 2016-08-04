/*
 * Container With Most Water
 * Tag: Array
 * Tag: Two Pointers
 */
import java.util.*;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int len = height.length;
        int l = 0, r = len - 1;
        int res = 0;
        while(l < r){
            // if height[l] < height[r], then for any i \in [l,r], f(l,i) <= height[l] * (r-l), which is the best result
            // similar to problem 3Sum Closet
            res = Math.max(Math.min(height[r], height[l]) * (r - l), res);
            if(height[l] < height[r]) l++;
            else r --;
        }
        
        return res;
    }
}