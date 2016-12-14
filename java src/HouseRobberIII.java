/*
 * House Robber III
 * Tag: Depth-first Search
 * Tag: Tree
 * Tag: Dynamic Programming
 */
import java.util.*;

public class HouseRobberIII {
    public int rob(TreeNode root) {
        int [] res = helper(root);
        return Math.max(res[0], res[1]);
    }
    
    private int[] helper(TreeNode root) {
        int [] res = new int[2];
        // TODO: Consider more about blank extreme result
        if(root == null) res[0] = res[1] = 0;
        else{
            int [] lRes = helper(root.left);
            int [] rRes = helper(root.right);
            res[0] = root.val + lRes[1] + rRes[1];
            res[1] = Math.max(lRes[0], lRes[1]) + Math.max(rRes[0], rRes[1]);
        }
        
        return res;
    }
}
