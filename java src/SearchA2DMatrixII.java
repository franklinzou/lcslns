/*
 * Search a 2D Matrix II
 * Tag: Divide and Conquer
 * Tag: Binary Search
 */
import java.util.*;

public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        // divide and conquer method:
        // basic idea: we split the whole area into four parts and discard either left top 
        // or right bottom part by comparing with smallest number in right bottom part
        if(matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        return searchRange(matrix, 0, m - 1, 0, n - 1, target);
        // TODO: O(m + n) method        
    }
    
    private boolean searchRange(int [][] matrix, int t, int b, int l, int r, int target) {
        if(t > b || l > r) return false;
        if(t == b && l == r) return matrix[t][l] == target;
        
        // piv the smallest element in the right bottom region:
        // if piv > targer, any number in the right bottom region cannot be target
        // if piv < target, any number in the left top region cannot be targer
        int mh = (l + r + 1) / 2, mv = (t + b + 1) / 2, piv = matrix[mv][mh];
        if(piv == target) return true;
        else if(piv > target) 
            return searchRange(matrix, t, mv - 1, l, mh - 1, target) || searchRange(matrix, mv, b, l, mh - 1, target)
            || searchRange(matrix, t, mv - 1, mh, r, target);
        else
            return searchRange(matrix, t, mv - 1, mh, r, target) || searchRange(matrix, mv, b, l, mh - 1, target)
            || searchRange(matrix, mv, b, mh, r, target);
    }
}
