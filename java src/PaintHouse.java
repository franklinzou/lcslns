/*
 * Paint House
 * Tag: Dynamic Programming
 */
import java.util.*;

public class PaintHouse {
    /*
     * dp[i][0..2] for minimal cost for painting wall[i] with red, green, blue respectively
     */
    public int minCost(int[][] costs) {
        int n = costs.length;
        // NOTE: General: default answer
        int [] dp = new int[3];
        for(int i = 0; i <= n - 1; i++){
            int [] tmp = dp.clone();
            for(int j = 0; j <= 2; j++)
                dp[j] = Math.min(tmp[(j + 1) % 3], tmp[(j + 2) % 3]) + costs[i][j];
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}