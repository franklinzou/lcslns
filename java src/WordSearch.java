/*
 * Word Search
 * Tag: Backtracking
 * Tag: Array
 */
import java.util.*;

public class WordSearch {
    private static final int [][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length == 0) return false;
        int m = board.length, n = board[0].length;
        boolean [][] used = new boolean[m][n];
        char [] str = word.toCharArray();
        for(int i = 0; i <= m - 1; i++)
            for(int j = 0; j <= n - 1; j++)
                if(helper(board, used, i, j, str, 0))
                    return true;
        return false;            
    }
    
    private boolean helper(char[][] board, boolean[][] used, int r, int c, char[] str, int s) {
        if(s == str.length) return true;
        int m = board.length, n = board[0].length;
        // invalid input screening
        if(!valid(r, c, m, n) || used[r][c] || board[r][c] != str[s]) return false;
        boolean res = false;
        used[r][c] = true;
        for(int i = 0; i <= 3; i++){
            if(helper(board, used, r + dirs[i][0], c + dirs[i][1], str, s + 1)){
                res = true;
                break;
            }
        }
        used[r][c] = false;
        return res;
    }
    
    private boolean valid(int r, int c, int m, int n) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}