/*
 * Valid Sudoku
 * Tag: Hash Table
 */
import java.util.*;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // Check if there exist distinct (i_0, j_0), (i_1, j_1) that share the same value but in the same region 
        // Use boolean array for mapping
        boolean [][] filled = new boolean[27][9];
        for(int i = 0; i <= 8; i ++)
            for(int j = 0; j <= 8; j ++){
                if(board[i][j] != '.'){
                    int ind = board[i][j] - '0' - 1;
                    if(filled[i][ind] || filled[9 + j][ind] || filled[18 + i / 3 * 3 + j / 3][ind])
                        return false;
                    filled[i][ind] = true;
                    filled[9 + j][ind] = true;
                    filled[18 + i / 3 * 3 + j / 3][ind] = true;
                }
            }
            
        return true;    
    }
}
