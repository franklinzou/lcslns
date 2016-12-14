/*
 * Perfect Squares
 * Tag: Dynamic Programming
 * Tag: Breadth-first Search
 * Tag: Math
 */
import java.util.*;

public class PerfectSquares {
    public int numSquares(int n) {
        // DP method-basic
        /*
        int [] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // invalid access
        for(int i = 1; i <= n; i++){
            for(int j = 1; j * j <= i; j++)
                if(dp[i - j * j] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
        }
        return dp[n];
        */
        // TODO: mathematical 
        
        // Breadth-first search
        int res = 0;
        boolean [] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<Integer>();
        visited[n] = true;
        q.offer(n);
        // Stop the loop if target is found
        while(!q.isEmpty() && !visited[0]) {
            res ++; // update res for nodes in the coming iteration
            int qSize = q.size();
            for(int i =1; i <= qSize; i ++) {
                int s = q.poll();
                for(int j = 1; j * j <= s; j ++) {
                    if(!visited[s - j * j]) {
                        q.offer(s - j * j);
                        visited[s - j * j] = true;
                    }
                }
            }
        }
        return res;
    }
}
