/*
 * Smallest Rectangle Enclosing Black Pixels
 * Tag: Binary Search
 */
import java.util.*;

public class SmallestRectangleEnclosingBlackPixels {
    public int minArea(char[][] image, int x, int y) {
        int m = image.length, n = image[0].length;
        int x1 = helper(image, m, 0, y, false, false);
        int x2 = helper(image, m, y, n - 1, false, true);
        int y1 = helper(image, n, 0, x, true, false);
        int y2 = helper(image, n, x, m - 1, true, true);
        // x2 and y2 must be valid (as x and y are valid), when x1 and y1 are not valid (-1), the equation
        // still works
        return (x2 - x1) * (y2 - y1);
    }
    
    // return greatest i such that i-range (does not) contain '1'
    private int helper(char[][] image, int rangeLen, int s, int e, boolean checkRow, boolean checkCon){
        int l = s, r = e;
        // any i < l, i-range is desirable; any i > r, i-range is not desirable
        while(l <= r){
            int m = l + (r - l + 1) / 2;
            boolean ifContain = checkCon(image, rangeLen, m, checkRow);
            if((ifContain && checkCon) || (!ifContain && !checkCon)) l = m + 1;
            else r = r - 1;
        }
        return r;
    }
    
    // check if i-range is desirable
    private boolean checkCon(char[][] image, int rangeLen, int ind, boolean checkRow){
        for(int i = 0; i <= rangeLen - 1; i++){
            int checkVal = checkRow ? image[ind][i] : image[i][ind];
            if(checkVal == '1') return true;
        }
        return false;
    }
}