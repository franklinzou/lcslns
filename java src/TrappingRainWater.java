/*
 * Trapping Rain Water
 * Tag: Array
 * Tag: Two Pointers
 * Tag: Stack
 */
import java.util.*;

public class TrappingRainWater {
    public int trap(int[] height) {
        // res[i] = min(max(height[S..i]), max(height[i..E])) - height[i]
        int len = height.length;
        // lHei = max(height[S..l - 1]), rHei = max(height[r+1..E])
        int l = 0, lHei = 0, r = len - 1, rHei = 0, res = 0;
        while(l <= r){
            lHei = Math.max(height[l], lHei);
            rHei = Math.max(height[r], rHei);
            if(lHei < rHei) res += lHei - height[l++];
            else res += rHei - height[r--];
        }
        
        return res;
        // TODO: stack method
    }
}