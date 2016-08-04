/*
 * Sum Root to Leaf Numbers
 * Tag: Tree
 * Tag: Depth-first Search
 */
import java.util.*;

public class SumRootToLeafNumbers {
    public int sumNumbers(TreeNode root) {
        int preSum = 0;
        return helper(preSum, root);
    }
    // return sum of all paths given preSum from root
    public int helper(int preSum, TreeNode root){
        if(root == null) return 0; // nop ending
        int newSum = preSum * 10 + root.val;
        if(root.left == null && root.right == null) return newSum; // summary ending
        return helper(newSum, root.left) + helper(newSum, root.right);
    }
}