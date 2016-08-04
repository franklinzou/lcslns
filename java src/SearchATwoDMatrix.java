/*
 * Search a 2D Matrix
 * Tag: Binary Search
 * Tag: Array
 */
import java.util.*;

public class SearchATwoDMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        // find greatest i in [0, m - 1] such that matrix[i][0] <= target
        int u = 0, d = m - 1;
        while(u <= d){
            int mid = u + (d - u + 1) / 2;
            if(matrix[mid][0] <= target) u = mid + 1;
            else d = mid - 1;
        }
        if(d < 0) return false; // if we cannot find desirable i, target does not exist

        // find greatest i in [0, n - 1] such that matrix[row][i] <= target
        int row = d, l = 0, r = n - 1;
        while(l <= r){
            int mid = l + (r - l + 1) / 2;
            if(matrix[row][mid] <= target) l = mid + 1;
            else r = mid - 1;
        }
        return l > 0 && matrix[row][r] == target;
        
    }
}