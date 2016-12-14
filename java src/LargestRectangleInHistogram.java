/*
 * Largest Rectangle in Histogram
 * Tag: Stack
 * Tag: Array
 */
import java.util.*;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<Integer>();
        int n = heights.length, res = 0;
        // Maintain a non-increasing height array
        // Note: type: assume we have a ending 0 to empty the stack in the end
        for(int i = 0; i <= n; i ++) {
            int h = (i <= n - 1 ? heights[i] : 0);
            while(!st.empty() && heights[st.peek()] > h) {
                int tp = st.peek(); st.pop();
                // can prove st.peek() is the left closest bar not higher than heights[tp], i is the
                // right closest bar strictly lower than heights[tp].
                // Optiaml result with a consecutive bars with the same height will be got when first
                // bar is poped up.
                int leftInd = st.empty() ? -1 : st.peek();
                // maximal area with heights[tp] being the minimal bar
                int area = heights[tp] * (i - leftInd - 1);
                res = Math.max(res, area);
            }
            st.push(i);
        }
        
        return res;
    }
}
